package co.com.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)	
public class ResponseDTO {
	
	private String mensaje;	
	private UserDTO user;
	
	
	
	public ResponseDTO(String mensaje) {
		super();
		this.mensaje = mensaje;		
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	

}
