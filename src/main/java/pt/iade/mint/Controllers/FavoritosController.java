package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Favoritos;
import pt.iade.mint.models.Repositories.FavoritosRepository;
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
@RequestMapping(path = "/api/favoritos")
public class FavoritosController {
    private Logger logger = LoggerFactory.getLogger(FavoritosController.class);
    @Autowired
    private FavoritosRepository favoritosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Favoritos> getFavoritos() {
        logger.info("Sending all favoritos");
        return favoritosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Favoritos getFavoritos(@PathVariable int id) {
        logger.info("Sending favoritos with id " + id);
        Optional<Favoritos> _favoritos = favoritosRepository.findById(id);
        if (_favoritos.isPresent())
            throw new NotFoundException("" + id, "Favoritos", "id");
        else
            return _favoritos.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Favoritos saveFavoritos(@RequestBody Favoritos favoritos) {
        Favoritos savedFavoritos = favoritosRepository.save(favoritos);
        logger.info("Saving favoritos with id " + savedFavoritos.getId_favoritos());
        return savedFavoritos;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteFavorito(@PathVariable int id) {
        logger.info("Deleting favoritos with id " + id);
        // No verification to see if it exists
        favoritosRepository.deleteById(id);
        return new Response("Deleted favoritos with id " + id, null);
    }
}
