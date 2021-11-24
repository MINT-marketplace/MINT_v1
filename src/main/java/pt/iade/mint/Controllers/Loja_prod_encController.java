package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Loja_prod_enc;
import pt.iade.mint.models.Repositories.Loja_prod_encRepository;
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
@RequestMapping(path = "/api/loja_prod_enc")
public class Loja_prod_encController {
    private Logger logger = LoggerFactory.getLogger(Loja_prod_encController.class);
    @Autowired
    private Loja_prod_encRepository loja_prod_encRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Loja_prod_enc> getLoja_prod_encs() {
        logger.info("Sending all loja_prod_encs");
        return loja_prod_encRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Loja_prod_enc getLoja_prod_enc(@PathVariable int id) {
        logger.info("Sending loja_prod_enc with id " + id);
        Optional<Loja_prod_enc> _loja_prod_enc = loja_prod_encRepository.findById(id);
        if (!_loja_prod_enc.isPresent())
            throw new NotFoundException("" + id, "Loja_prod_enc", "id");
        else
            return _loja_prod_enc.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Loja_prod_enc saveLoja_prod_enc(@RequestBody Loja_prod_enc loja_prod_enc) {
        Loja_prod_enc savedLoja_prod_enc = loja_prod_encRepository.save(loja_prod_enc);
        logger.info("Saving loja_prod_enc with id " + savedLoja_prod_enc.getId());
        return savedLoja_prod_enc;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteLoja_prod_enc(@PathVariable int id) {
        logger.info("Deleting loja_prod_enc with id " + id);
        // No verification to see if it exists
        loja_prod_encRepository.deleteById(id);
        return new Response("Deleted loja_prod_enc with id " + id, null);
    }
}
