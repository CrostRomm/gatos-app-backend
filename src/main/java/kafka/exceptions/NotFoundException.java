package kafka.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 *Excepcion personalizada para un Not Found HTTP_ERROR(404) 
 * @author Cristian Romero
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String mensaje) {		
		super(mensaje);
	}
}