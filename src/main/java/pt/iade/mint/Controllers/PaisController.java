package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Pais;
import pt.iade.mint.models.Repositories.PaisRepository;
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
@RequestMapping(path = "/api/pais")
public class PaisController {
    private Logger logger = LoggerFactory.getLogger(PaisController.class);
    @Autowired
    private PaisRepository paisRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pais> getPais() {
        logger.info("Sending all Pais");
        return paisRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais getPais(@PathVariable int id) {
        logger.info("Sending pais with id " + id);
        Optional<Pais> _pais = paisRepository.findById(id);
        if (!_pais.isPresent())
            throw new NotFoundException("" + id, "Pais", "id");
        else
            return _pais.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais savePais(@RequestBody Pais pais) {
        Pais savedPais = paisRepository.save(pais);
        logger.info("Saving pais with id " + savedPais.getIdpais());
        return savedPais;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePais(@PathVariable int id) {
        logger.info("Deleting pais with id " + id);
        // No verification to see if it exists
        paisRepository.deleteById(id);
        return new Response("Deleted pais with id " + id, null);
    }
}
