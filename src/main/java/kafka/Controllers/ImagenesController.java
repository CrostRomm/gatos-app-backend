package kafka.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kafka.Models.Imagenes;
import kafka.Services.Interfaces.IPictureService;

@CrossOrigin(origins = {"*","http://localhost:4200"})
@RestController
@RequestMapping("imagenes")
public class ImagenesController {
	
	@Autowired
	IPictureService service;
	
	@GetMapping()
	public ResponseEntity<List<Imagenes>> listar10Imagenes(){
		List<Imagenes> listaImagenes = service.listarImagenes();
		return new ResponseEntity<List<Imagenes>>(listaImagenes, HttpStatus.OK);		
	}
	
	
	@PostMapping("/favoritos")
	public ResponseEntity<Imagenes> marcarFavorito(@RequestBody Imagenes imagen){
		Imagenes image = service.marcarFavorito(imagen);
		return new ResponseEntity<Imagenes>(image, HttpStatus.CREATED);
	}	
	//http://localhost:8080/imagenes/favoritos
	@GetMapping("/favoritos")
	public ResponseEntity<List<Imagenes>> listarFavoritas(){
		List<Imagenes> listaFavoritas = service.listarFavoritas();
		return new ResponseEntity<List<Imagenes>>(listaFavoritas, HttpStatus.OK);		
	}	

}
