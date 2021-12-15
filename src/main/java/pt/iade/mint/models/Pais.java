package pt.iade.mint.models;

import javax.persistence.*;

@Entity
    @Table(name = "pais")
public class Pais {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais", nullable = false)
    private Integer idpais;

    @Column(name = "nome_pais", nullable = false, length = 30)
    private String nomePais;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setId(Integer id) {
        this.idpais = id;
    }
}
