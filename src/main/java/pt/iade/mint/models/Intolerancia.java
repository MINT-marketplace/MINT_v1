package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "Intolerancia")
public class Intolerancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intolerancia", nullable = false)
    private Integer idintolerancia;

    @Column(name = "intolerancia", length = 30)
    private String intolerancia;

    public String getIntolerancia() {
        return intolerancia;
    }

    public void setIntolerancia(String intolerancia) {
        this.intolerancia = intolerancia;
    }

    public Integer getIdintolerancia() {
        return idintolerancia;
    }

    public void setId(Integer id) {
        this.idintolerancia = id;
    }
}
