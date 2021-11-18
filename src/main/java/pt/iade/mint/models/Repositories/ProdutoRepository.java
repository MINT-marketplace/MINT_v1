package pt.iade.mint.models.Repositories;

import pt.iade.mint.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
