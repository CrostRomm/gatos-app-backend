package kafka.Models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Modelo de la coleccion gatos mapeada
 * @author Cristian Romero
 *
 */
@Document(collection="gatos")
public class Gatos implements Serializable{ 
	
	@Id
	private String id;
	private String nombre;
	private String raza;
	private int edad;
	private String foto;
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRaza() {
		return raza;
	}



	public void setRaza(String raza) {
		this.raza = raza;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -3903414084475962878L;

}
