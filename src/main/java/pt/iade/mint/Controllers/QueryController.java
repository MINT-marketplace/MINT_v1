package pt.iade.mint.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.mint.models.Produto;
import pt.iade.mint.models.Rating;
import pt.iade.mint.models.Utilizador;
import pt.iade.mint.models.Repositories.QueryRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/querys")
public class QueryController {

    private final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(path = "/existe/{nome:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.Exite_utilizador(nome,pass);
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


    @GetMapping(path = "/rating_lojas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_rating_lojas() {
        logger.info("Sending bio from route " );
        return queryRepository.rating_lojas();
    }


    @GetMapping(path = "/rating_produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_rating_produtos() {
        logger.info("Sending bio from rout" );
        return queryRepository.rating_produtos();
    }


    @GetMapping(path = "/utilizador_info/{nome:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> get_utilizador_info(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.utilizador_info(nome,pass);
    }



}
