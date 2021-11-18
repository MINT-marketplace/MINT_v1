package pt.iade.mint.models;

import javax.persistence.*;

@Entity
    @Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais", nullable = false)
    private Integer id_pais;

    @Column(name = "nome_pais", nullable = false, length = 30)
    private String nomePais;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }
}
