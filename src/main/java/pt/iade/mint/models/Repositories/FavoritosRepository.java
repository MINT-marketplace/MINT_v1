package pt.iade.mint.models.Repositories;


import pt.iade.mint.models.Favoritos;
import org.springframework.data.repository.CrudRepository;

public interface FavoritosRepository extends CrudRepository<Favoritos, Integer> {
}
