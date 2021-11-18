package pt.iade.mint.models;

import javax.persistence.*;

@Entity
    @Table(name="encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encomenda", nullable = false)
    private Integer id_encomenda;

    @Column(name = "id_utilizador", nullable = false)
    private Integer idUtilizador;

    @Column(name = "precot", nullable = false)
    private Integer precot;

    public Integer getPrecot() {
        return precot;
    }

    public void setPrecot(Integer precot) {
        this.precot = precot;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getId() {
        return id_encomenda;
    }

    public void setId(Integer id_encomenda) {
        this.id_encomenda = id_encomenda;
    }
}
