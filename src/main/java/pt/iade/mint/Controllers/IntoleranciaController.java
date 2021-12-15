package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Intolerancia;
import pt.iade.mint.models.Repositories.IntoleranciaRepository;
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
@RequestMapping(path = "/api/intolerancia")
public class IntoleranciaController {
    private Logger logger = LoggerFactory.getLogger(IntoleranciaController.class);
    @Autowired
    private IntoleranciaRepository intoleranciaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Intolerancia> getIntolerancias() {
        logger.info("Sending all Intolerancias");
        return intoleranciaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Intolerancia getIntolerancia(@PathVariable int id) {
        logger.info("Sending Intolerancia with id " + id);
        Optional<Intolerancia> _Intolerancia = intoleranciaRepository.findById(id);
        if (!_Intolerancia.isPresent())
            throw new NotFoundException("" + id, "Intolerancia", "id");
        else
            return _Intolerancia.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Intolerancia saveIntolerancia(@RequestBody Intolerancia intolerancia) {
        Intolerancia savedIntolerancia = intoleranciaRepository.save(intolerancia);
        logger.info("Saving Intolerancia with id " + savedIntolerancia.getIdintolerancia());
        return savedIntolerancia;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteIntolerancia(@PathVariable int id) {
        logger.info("Deleting intolerancia with id " + id);
        // No verification to see if it exists
        intoleranciaRepository.deleteById(id);
        return new Response("Deleted intolerancia with id " + id, null);
    }
}
