package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Encomenda;
import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Repositories.EncomendaRepository;
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
@RequestMapping(path = "/api/encomenda")
public class EncomendaController {
    private Logger logger = LoggerFactory.getLogger(EncomendaController.class);
    @Autowired
    private EncomendaRepository encomendaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Encomenda> getEncomendas() {
        logger.info("Sending all Encomendas");
        return encomendaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Encomenda getEncomenda(@PathVariable int id) {
        logger.info("Sending Encomenda with id " + id);
        Optional<Encomenda> _encomenda = encomendaRepository.findById(id);
        if (!_encomenda.isPresent())
            throw new NotFoundException("" + id, "Encomenda", "id");
        else
            return _encomenda.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Encomenda saveEncomenda(@RequestBody Encomenda encomenda) {
        Encomenda savedEncomenda = encomendaRepository.save(encomenda);
        logger.info("Saving encomenda with id " + savedEncomenda.getId());
        return savedEncomenda;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEncomenda(@PathVariable int id) {
        logger.info("Deleting encomenda with id " + id);
        // No verification to see if it exists
        encomendaRepository.deleteById(id);
        return new Response("Deleted encomenda with id " + id, null);
    }
}
