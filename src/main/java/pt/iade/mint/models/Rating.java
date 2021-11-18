package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating", nullable = false)
    private Integer id_rating;

    @Column(name = "id_utilizador", nullable = false)
    private Integer idUtilizador;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getId_rating() {
        return id_rating;
    }

    public void setId_rating(Integer id_rating) {
        this.id_rating = id_rating;
    }
}
