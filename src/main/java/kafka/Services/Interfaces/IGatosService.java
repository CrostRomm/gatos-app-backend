package kafka.Services.Interfaces;

import java.util.List;
import org.springframework.core.io.Resource;

import org.springframework.web.multipart.MultipartFile;

import kafka.Models.Gatos;
/**
 * interfaz de acceso a los metodos crud de gatos
 * @author Cristian Romero
 *
 */
public interface IGatosService {

	public List<Gatos> listarGatos();
	
	public Gatos buscarGato(String id);
	
	public Gatos agregarGato(Gatos gato);
	
	public Gatos editarInfoGato(Gatos gato, String id);
	
	public void eliminarGato(String id);
	
	public Gatos upload(MultipartFile archivo, String id);
		
		public Resource verFoto(String nombreFoto);
	
}
