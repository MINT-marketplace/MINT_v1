package pt.iade.mint.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.mint.models.Utilizador;
import pt.iade.mint.models.Repositories.QueryRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/querys")
public class QueryController {

    private final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(path = "/exite/{nome:[.-z]+}/{pass:[0-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("nome") String nome, @PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome + pass);
        return queryRepository.Exite_utilizador(nome, pass);
    }

    @GetMapping(path = "/teste/{nome:[.-z]+}/{pass:[0-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_teste(@PathVariable("nome") String nome, @PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome + pass);
        return queryRepository.teste(nome, pass);
    }

    @GetMapping(path = "/encomendastotais/{nome:[.-z]+}/{pass:[0-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_encomendas(@PathVariable("nome") String nome, @PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome + pass);
        return queryRepository.encomendas(nome, pass);
    }



}
