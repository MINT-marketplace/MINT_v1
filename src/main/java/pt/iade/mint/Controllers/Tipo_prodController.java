package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Repositories.Tipo_prodRepository;
import pt.iade.mint.models.Tipo_prod;
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
@RequestMapping(path = "/api/tipo_prod")
public class Tipo_prodController {
    private Logger logger = LoggerFactory.getLogger(Tipo_prodController.class);
    @Autowired
    private Tipo_prodRepository tipo_prodRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tipo_prod> getTipo_prods() {
        logger.info("Sending all tipo_prods");
        return tipo_prodRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tipo_prod getTipo_prod(@PathVariable int id) {
        logger.info("Sending tipo_prod with id " + id);
        Optional<Tipo_prod> _tipo_prod = tipo_prodRepository.findById(id);
        if (!_tipo_prod.isPresent())
            throw new NotFoundException("" + id, "Tipo_prod", "id");
        else
            return _tipo_prod.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tipo_prod saveTipo_prod(@RequestBody Tipo_prod tipo_prod) {
        Tipo_prod savedTipo_prod = tipo_prodRepository.save(tipo_prod);
        logger.info("Saving tipo_prod with id " + savedTipo_prod.getIdtipoprod());
        return savedTipo_prod;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTipo_prod(@PathVariable int id) {
        logger.info("Deleting tipo_prod with id " + id);
        // No verification to see if it exists
        tipo_prodRepository.deleteById(id);
        return new Response("Deleted tipo_prod with id " + id, null);
    }
}
