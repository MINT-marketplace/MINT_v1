package pt.iade.mint.models.Repositories;

import org.springframework.data.jpa.repository.Query;
import pt.iade.mint.models.Utilizador;
import org.springframework.data.repository.CrudRepository;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer> {

}
