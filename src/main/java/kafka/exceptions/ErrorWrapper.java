package kafka.exceptions;

import java.time.LocalDateTime;

public class ErrorWrapper {
	/**
	 * Fecha del error
	 */
	private LocalDateTime timestamp;
	/**
	 * Numero estado
	 */
	private int status;
	/**
	 * Nombre de estado
	 */
	private String error;
	/**
	 * Mensaje
	 */
	private String message;
	/**
	 * Stack de errores
	 */
	private String path;
	/**
	 * Constructor
	 */
	public ErrorWrapper() {
				
	}	
	/**
	 * Constructor
	 * @param status
	 * @param error
	 * @param message
	 * @param path
	 */
	public ErrorWrapper(int status, String error, String message, String path) {
		super();
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	/**
	 * Get fecha
	 * @return
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * Set fecha
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * get estado
	 * @return
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * set estado
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * get error
	 * @return
	 */
	public String getError() {
		return error;
	}
	/**
	 * set error
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * get mensaje
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * set mensaje
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * get stack
	 * @return
	 */
	public String getPath() {
		return path;
	}
	/**
	 * set stack
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
