package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Lista_compras;
import pt.iade.mint.models.Repositories.Lista_comprasRepository;
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
@RequestMapping(path = "/api/lista_compras")
public class Lista_comprasController {
    private Logger logger = LoggerFactory.getLogger(Lista_comprasController.class);
    @Autowired
    private Lista_comprasRepository lista_comprasRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Lista_compras> getLista_compras() {
        logger.info("Sending all lista_comprass");
        return lista_comprasRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Lista_compras getLista_compras(@PathVariable int id) {
        logger.info("Sending lista_compras with id " + id);
        Optional<Lista_compras> _lista_compras = lista_comprasRepository.findById(id);
        if (!_lista_compras.isPresent())
            throw new NotFoundException("" + id, "Lista_compras", "id");
        else
            return _lista_compras.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Lista_compras saveLista_compras(@RequestBody Lista_compras lista_compras) {
        Lista_compras savedLista_compras = lista_comprasRepository.save(lista_compras);
        logger.info("Saving lista_compras with id " + savedLista_compras.getIdlista());
        return savedLista_compras;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteLista_compras(@PathVariable int id) {
        logger.info("Deleting lista_compras with id " + id);
        // No verification to see if it exists
        lista_comprasRepository.deleteById(id);
        return new Response("Deleted lista_compras with id " + id, null);
    }
}

