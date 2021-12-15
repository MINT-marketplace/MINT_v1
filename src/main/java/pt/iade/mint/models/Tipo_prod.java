package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "tipo_prod")
public class Tipo_prod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_prod", nullable = false)
    private Integer idtipoprod;

    @Column(name = "tipo_prod", length = 30)
    private String tipoProd;

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Integer getIdtipoprod() {
        return idtipoprod;
    }

    public void setId(Integer id) {
        this.idtipoprod = id;
    }
}
