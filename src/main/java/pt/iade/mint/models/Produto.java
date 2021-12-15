package pt.iade.mint.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Integer idproduto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_prod", nullable = false)
    private Tipo_prod idTipoProd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_intolerancia", nullable = false)
    private Intolerancia idIntolerancia;

    @Column(name = "id_loja", nullable = false, length = 60)
    private String idLoja;

    @Column(name = "produto_nome", nullable = false, length = 60)
    private String produtoNome;

    @Column(name = "produto_preco", nullable = false)
    private BigDecimal produtoPreco;

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

    public String getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(String idLoja) {
        this.idLoja = idLoja;
    }

    public Intolerancia getIdIntolerancia() {
        return idIntolerancia;
    }

    public void setIdIntolerancia(Intolerancia idIntolerancia) {
        this.idIntolerancia = idIntolerancia;
    }

    public Tipo_prod getIdTipoProd() {
        return idTipoProd;
    }

    public void setIdTipoProd(Tipo_prod idTipoProd) {
        this.idTipoProd = idTipoProd;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setId(Integer id) {
        this.idproduto = id;
    }
}
