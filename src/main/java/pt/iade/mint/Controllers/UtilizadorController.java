package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Repositories.UtilizadorRepository;
import pt.iade.mint.models.Utilizador;
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
@RequestMapping(path = "/api/utilizador")
public class UtilizadorController {
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class);
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadors() {
        logger.info("Sending all utilizadors");
        return utilizadorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizador(@PathVariable int id) {
        logger.info("Sending utilizador with id " + id);
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if (_utilizador.isPresent())
            throw new NotFoundException("" + id, "Utilizador", "id");
        else
            return _utilizador.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador) {
        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Saving utilizador with id " + savedUtilizador.getId_utilizador());
        return savedUtilizador;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUtilizador(@PathVariable int id) {
        logger.info("Deleting utilizador with id " + id);
        // No verification to see if it exists
        utilizadorRepository.deleteById(id);
        return new Response("Deleted utilizador with id " + id, null);
    }
}
