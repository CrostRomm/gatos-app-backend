package kafka.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import kafka.Models.Gatos;
import kafka.Services.Interfaces.IGatosService;
/**
 * Controlador de peticiones REST
 * @author Cristian Romero
 *
 */
@CrossOrigin(origins = {"*","http://localhost:4200"})
@RestController
@RequestMapping("gatos")
public class GatosController {
	
	@Autowired
	IGatosService service;
	
	@GetMapping()
	public ResponseEntity<List<Gatos>> listar(){
		List<Gatos> listaGatos = service.listarGatos();
		
		return new ResponseEntity<List<Gatos>>(listaGatos, HttpStatus.OK);		
	}	

	@GetMapping("/{id}")
	public ResponseEntity<Gatos> buscar(@PathVariable String id){
		Gatos gato = service.buscarGato(id);

		return new ResponseEntity<Gatos>(gato, HttpStatus.OK);		
	}		
	
	@PostMapping()
	public ResponseEntity<Gatos> guardar(@RequestBody Gatos gato) {
		Gatos minino = service.agregarGato(gato);
		return new ResponseEntity<Gatos>(minino, HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Gatos> editar(@RequestBody Gatos gato, @PathVariable String id) {
		Gatos minino = service.editarInfoGato(gato,id);
		return new ResponseEntity<Gatos>(minino, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id) {
		service.eliminarGato(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
