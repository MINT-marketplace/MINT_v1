package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "lista_compras")
public class Lista_compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista", nullable = false)
    private Integer id_lista;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Column(name = "id_produtor", nullable = false)
    private Integer idProdutor;

    @Column(name = "id_rating", nullable = false)
    private Integer idRating;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "precot", nullable = false)
    private Integer precot;

    public Integer getPrecot() {
        return precot;
    }

    public void setPrecot(Integer precot) {
        this.precot = precot;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdRating() {
        return idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }

    public Integer getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(Integer idProdutor) {
        this.idProdutor = idProdutor;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getId() {
        return id_lista;
    }

    public void setId(Integer id) {
        this.id_lista = id_lista;
    }
}
