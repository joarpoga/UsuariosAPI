package co.com.api.mediator;


import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.api.dto.ResponseDTO;
import co.com.api.dto.UserDTO;
import co.com.api.jpa.PhoneJPA;
import co.com.api.jpa.UserJPA;
import co.com.api.repository.PhoneRepository;
import co.com.api.repository.UserRepository;

@Component
public class UsuarioMed {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$");
	@Autowired
	UserRepository usrR;
	
	@Autowired
	PhoneRepository phonR;
	
	public Iterable<UserJPA> listar() {
		return usrR.findAll();
	}
	
	@PostMapping("/") 
	public ResponseDTO crear(@RequestBody UserJPA usr) throws Exception {				
		ResponseDTO respon = null;
		try {
			System.out.println(usr.getPassword());
			 
			if(usr !=null && usr.getEmail() != null && ((Matcher)VALID_EMAIL_ADDRESS_REGEX.matcher(usr.getEmail())).find()) {
				if(usr !=null && usr.getPassword()!= null && ((Matcher)VALID_PASSWORD_REGEX.matcher(usr.getPassword())).find()) {
					usr.setIsactive(1);
					usr.setLast_Login(new Date());
					usr.setCreate_date(new Date());
					usr.setTokend(UUID.randomUUID().toString());
					
					usr = usrR.save(usr);
					
					for(PhoneJPA phone: usr.getListPhones()) {
						phone.setUser(usr);
						phonR.save(phone);
					}
					
					respon = new ResponseDTO("Usuario creado con éxito");
					respon.setUser(new UserDTO());
					respon.getUser().setCreated(usr.getCreate_date());
					respon.getUser().setId(usr.getId().toString());	
					respon.getUser().setIsactive(usr.getIsactive().toString());
					respon.getUser().setLastLogin(usr.getLast_Login());
					respon.getUser().setModified(usr.getUpdate_date());
					respon.getUser().setTokend(usr.getTokend().toString());
				}else {
					throw new Exception("El pasrrwod no tiene la seguridad requerida debe contener (letras mayusculas, letras minúsculas y numeros)");
				}
				
			}else {
				throw new Exception("El correo no tiene un formato valido");
			}						 
			
		} catch (DataIntegrityViolationException e) {	
			System.out.println(e.getMessage());
			throw new Exception("El correo ya registrado");
		} catch (Exception e) {		
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		return respon;
	} 
}
