package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Regiao;
import pt.iade.mint.models.Repositories.RegiaoRepository;
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
@RequestMapping(path = "/api/regiao")
public class RegiaoController {
    private Logger logger = LoggerFactory.getLogger(RegiaoController.class);
    @Autowired
    private RegiaoRepository regiaoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Regiao> getRegiaos() {
        logger.info("Sending all regiaos");
        return regiaoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Regiao getRegiao(@PathVariable int id) {
        logger.info("Sending regiao with id " + id);
        Optional<Regiao> _regiao = regiaoRepository.findById(id);
        if (_regiao.isEmpty())
            throw new NotFoundException("" + id, "Regiao", "id");
        else
            return _regiao.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Regiao saveRegiao(@RequestBody Regiao regiao) {
        Regiao savedRegiao = regiaoRepository.save(regiao);
        logger.info("Saving regiao with id " + savedRegiao.getId_regiao());
        return savedRegiao;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRegiao(@PathVariable int id) {
        logger.info("Deleting regiao with id " + id);
        // No verification to see if it exists
        regiaoRepository.deleteById(id);
        return new Response("Deleted regiao with id " + id, null);
    }
}
