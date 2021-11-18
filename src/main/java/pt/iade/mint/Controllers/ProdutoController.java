package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Produto;
import pt.iade.mint.models.Repositories.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/produto")
public class ProdutoController {
    private Logger logger = LoggerFactory.getLogger(ProdutoController.class);
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Produto> getProdutos() {
        logger.info("Sending all produtos");
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto getProduto(@PathVariable int id) {
        logger.info("Sending produto with id " + id);
        Optional<Produto> _produto = produtoRepository.findById(id);
        if (_produto.isEmpty())
            throw new NotFoundException("" + id, "Produto", "id");
        else
            return _produto.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto saveProduto(@RequestBody Produto produto) {
        Produto savedProduto = produtoRepository.save(produto);
        logger.info("Saving produto with id " + savedProduto.getId_produto());
        return savedProduto;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteProduto(@PathVariable int id) {
        logger.info("Deleting produto with id " + id);
        // No verification to see if it exists
        produtoRepository.deleteById(id);
        return new Response("Deleted produto with id " + id, null);
    }
}
