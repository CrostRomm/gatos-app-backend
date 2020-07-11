package kafka.Services;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kafka.Models.Gatos;
import kafka.Repositories.IGatosRepository;
import kafka.Services.Interfaces.IGatosService;
import kafka.exceptions.NotFoundException;

 

/**
 * Implementación de interfaz de metodos crud de gatos
 * @author Cristian Romero
 *
 */
@Service
public class GatoService implements IGatosService{

	
	private final Logger log = LoggerFactory.getLogger(GatoService.class);
	
	@Autowired
	IGatosRepository repositorio;
	
	@Override
	public List<Gatos> listarGatos() {
		List<Gatos> listaGatos = repositorio.findAll();
		if(listaGatos==null) {
			throw new NotFoundException("la lista esta vacia");
		}
		return listaGatos;
	}

	@Override
	public Gatos buscarGato(String id) {
		return repositorio.findById(id).orElseThrow(
				() -> new NotFoundException("No existe este gato"));
	}

	@Override
	public Gatos agregarGato(Gatos gato) {
		return repositorio.save(gato);
	}

	@Override
	public Gatos editarInfoGato(Gatos gato, String id) {
		if(repositorio.existsById(id)) {
			return repositorio.save(gato);
		}else {
			throw new NotFoundException("No existe el gato");
		}
		
	}

	@Override
	public void eliminarGato(String id){
		if(repositorio.existsById(id)) {
			repositorio.deleteById(id);
		}else {
			throw new NotFoundException("No existe este gato");
		}
	}

	@Override
	public Gatos upload(MultipartFile archivo, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource verFoto(String nombreFoto) {
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		log.info(rutaArchivo.toString());
		try {
			Resource recurso = new UrlResource(rutaArchivo.toUri());
			if(!recurso.exists() && !recurso.isReadable()) {
				throw new NotFoundException("No se encuentra la foto");
			}
			return recurso;
		} catch (MalformedURLException e) {
			throw new NotFoundException("No se encuentra la foto");
		}
	}

}
