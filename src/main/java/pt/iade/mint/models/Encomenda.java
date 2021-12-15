package pt.iade.mint.models;

import javax.persistence.*;

@Entity
    @Table(name="encomenda")
public class Encomenda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encomenda", nullable = false)
    private Integer idencomenda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_utilizador", nullable = false)
    private Utilizador idUtilizador;

    @Column(name = "precot", nullable = false)
    private Integer precot;

    public Integer getPrecot() {
        return precot;
    }

    public void setPrecot(Integer precot) {
        this.precot = precot;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdencomenda() {
        return idencomenda;
    }

    public void setId(Integer id) {
        this.idencomenda = id;
    }
}
