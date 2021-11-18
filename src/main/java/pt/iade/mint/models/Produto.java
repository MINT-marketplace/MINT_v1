package pt.iade.mint.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Integer id_produto;

    @Column(name = "id_tipo_prod", nullable = false)
    private Integer idTipoProd;

    @Column(name = "produto_nome", nullable = false, length = 60)
    private String produtoNome;

    @Column(name = "produto_preco", nullable = false)
    private BigDecimal produtoPreco;

    @Column(name = "produto_quantidade", nullable = false)
    private Integer produtoQuantidade;

    public Integer getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(Integer produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public BigDecimal getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(BigDecimal produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Integer getIdTipoProd() {
        return idTipoProd;
    }

    public void setIdTipoProd(Integer idTipoProd) {
        this.idTipoProd = idTipoProd;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }
}
