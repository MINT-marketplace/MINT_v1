package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "tipo_prod")
public class Tipo_prod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_prod", nullable = false)
    private Integer id_tipo_prod;

    @Column(name = "tipo_prod", length = 30)
    private String tipoProd;

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Integer getId_tipo_prod() {
        return id_tipo_prod;
    }

    public void setId_tipo_prod(Integer id_tipo_prod) {
        this.id_tipo_prod = id_tipo_prod;
    }
}
