package kafka.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import kafka.Models.Gatos;
/**
 * Interfaz que sirve como repositorio para el crud de los gatos
 * @author Cristian Romero
 *
 */
@Repository
public interface IGatosRepository extends MongoRepository<Gatos, String>{

}
