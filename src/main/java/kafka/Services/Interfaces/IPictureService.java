package kafka.Services.Interfaces;
import java.util.List;

import kafka.Models.Imagenes;

public interface IPictureService {
	
	public List<Imagenes> listarImagenes();
	
	public Imagenes marcarFavorito(Imagenes imagen);
	
	public List<Imagenes> listarFavoritas(); 
}
