package co.com.api.ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.api.dto.ResponseDTO;
import co.com.api.jpa.UserJPA;
import co.com.api.mediator.UsuarioMed;


@RestController	
public class UserController {
	
	@Autowired
	UsuarioMed usrM;
	
	@GetMapping("/") 
	public Iterable<UserJPA> principal() {
		return usrM.listar();
	}
	
	@PostMapping("/") 
	public ResponseEntity<ResponseDTO> crear(@RequestBody UserJPA usr) {						
		try {				
			return new ResponseEntity<>(usrM.crear(usr),HttpStatus.OK);
		} catch (Exception e) {			
			return new ResponseEntity<>( new ResponseDTO(e.getMessage()),HttpStatus.NOT_FOUND);
		}
		
	}

}
