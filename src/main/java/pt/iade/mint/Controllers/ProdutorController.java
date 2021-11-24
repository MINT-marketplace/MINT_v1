package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Produtor;
import pt.iade.mint.models.Repositories.ProdutorRepository;
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
@RequestMapping(path = "/api/produtor")
public class ProdutorController {
    private Logger logger = LoggerFactory.getLogger(ProdutorController.class);
    @Autowired
    private ProdutorRepository produtorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Produtor> getProdutors() {
        logger.info("Sending all produtors");
        return produtorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produtor getProdutor(@PathVariable int id) {
        logger.info("Sending produtor with id " + id);
        Optional<Produtor> _produtor = produtorRepository.findById(id);
        if (!_produtor.isPresent())
            throw new NotFoundException("" + id, "Produtor", "id");
        else
            return _produtor.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produtor saveProdutor(@RequestBody Produtor produtor) {
        Produtor savedProdutor = produtorRepository.save(produtor);
        logger.info("Saving produtor with id " + savedProdutor.getId_loja());
        return savedProdutor;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteProdutor(@PathVariable int id) {
        logger.info("Deleting produtor with id " + id);
        // No verification to see if it exists
        produtorRepository.deleteById(id);
        return new Response("Deleted produtor with id " + id, null);
    }
}
