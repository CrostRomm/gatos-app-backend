package kafka.Services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kafka.Models.Imagenes;
import kafka.Services.Interfaces.IPictureService;

@Service
public class ImagenService implements IPictureService{
	
	public static List<Imagenes> listaPictures = new ArrayList<>();
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Imagenes> listarImagenes() {
		
		List<Imagenes> listaImagenes = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			listaImagenes.add(consumoApiGatos().get(
					(int)(Math.random()*consumoApiGatos().size())
					));
		}
		return listaImagenes;
	}

	@Override
	public Imagenes marcarFavorito(Imagenes imagen) {
		listaPictures.add(imagen);
		return imagen;
	}

	@Override
	public List<Imagenes> listarFavoritas() {
		return listaPictures;
	}
	
	public List<Imagenes> consumoApiGatos(){
		String url = "https://api.thecatapi.com/v1/images/search";
		Imagenes[] response = restTemplate.getForObject(url, Imagenes[].class);
		
		return Arrays.asList(response);
	}

}
