package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating", nullable = false)
    private Integer idrating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_lista", nullable = false)
    private Lista_compras idLista;

    @Column(name = "rateloja", nullable = false)
    private Double rateloja;

    @Column(name = "rateproduto", nullable = false)
    private Double rateproduto;

    public Double getRateproduto() {
        return rateproduto;
    }

    public void setRateproduto(Double rateproduto) {
        this.rateproduto = rateproduto;
    }

    public Double getRateloja() {
        return rateloja;
    }

    public void setRateloja(Double rateloja) {
        this.rateloja = rateloja;
    }

    public Lista_compras getIdLista() {
        return idLista;
    }

    public void setIdLista(Lista_compras idLista) {
        this.idLista = idLista;
    }

    public Integer getIdrating() {
        return idrating;
    }

    public void setId(Integer id) {
        this.idrating = id;
    }
}
