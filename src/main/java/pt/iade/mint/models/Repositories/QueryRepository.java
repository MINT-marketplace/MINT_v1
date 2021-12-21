package pt.iade.mint.models.Repositories;

import pt.iade.mint.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QueryRepository extends CrudRepository<Utilizador, Integer> {

    String encomenda ="select encomenda.id_encomenda,utilizador.id_utilizador,produto.produto_nome,utilizador_nome,encomenda.precot from encomenda inner join utilizador on encomenda.id_utilizador = utilizador.id_utilizador inner join loja_prod_enc on encomenda.id_encomenda = loja_prod_enc.id_encomenda inner join lista_compras on lista_compras.id_lista = loja_prod_enc.id_lista inner join produto on lista_compras.id_produto = produto.id_produto";

    @Query(value = "select utilizador_existe(:nome,:pass)", nativeQuery = true)
    Iterable<String> Exite_utilizador(String nome, String pass);

    @Query(value = "select * from utilizador where utilizador_email = :nome and utilizador_pass = :pass", nativeQuery = true)
    Iterable<String> teste(String nome, String pass);

    @Query(value = encomenda + " where utilizador_email = :nome and utilizador_pass = :pass", nativeQuery = true)
    Iterable<String> encomendas(String nome, String pass);

    @Query(value = "select id_loja, avg(rateloja) from rating\n" +
            "inner join lista_compras on lista_compras.id_lista = rating.id_lista\n" +
            "inner join produtor on lista_compras.id_produtor= produtor.id_loja\n" +
            "group by id_loja", nativeQuery = true)
    Iterable<String> rating_lojas();

    @Query(value = "select produto.id_produto, avg(rateproduto) from rating\n" +
            "inner join lista_compras on lista_compras.id_lista = rating.id_lista\n" +
            "inner join produto on lista_compras.id_produto= produto.id_produto\n" +
            "group by produto.id_produto", nativeQuery = true)
    Iterable<String> rating_produtos();


}
