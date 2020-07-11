package kafka.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * 
 * @author Cristian Romero
 * Administador de excepciones
 *
 */
public class ExceptionsHandler extends ResponseEntityExceptionHandler{
	/**
	 * Not found 404 exception
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorWrapper> manejadorModelException(NotFoundException ex,
			WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
		   return new ResponseEntity<ErrorWrapper>(er, HttpStatus.NOT_FOUND);					
	}	
	/**
	 * Argument not valid exception
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {		
		ErrorWrapper er = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
	/**
	 * Method not supported exception
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.METHOD_NOT_ALLOWED);
	}
	/**
	 * Http message not readable exception
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);		
	}	
	/**
	 * No handler found exception
	 */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
				HttpStatus status, WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
		}	
	/**
	 * Media not supported exception
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}		
	/**
	 * 500 ISE Internal server error
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorWrapper> manejarException(Exception ex,
			WebRequest request) {
		ErrorWrapper er = new ErrorWrapper(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), request.getDescription(false));
		   return new ResponseEntity<ErrorWrapper>(er, HttpStatus.INTERNAL_SERVER_ERROR);					
	}
}
