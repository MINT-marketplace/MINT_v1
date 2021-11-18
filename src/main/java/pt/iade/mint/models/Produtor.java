package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "produtor")
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja", nullable = false)
    private Integer id_loja;

    @Column(name = "loja_nome", nullable = false, length = 60)
    private String lojaNome;

    @Column(name = "id_regiao", nullable = false)
    private Integer idRegiao;

    public Integer getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getLojaNome() {
        return lojaNome;
    }

    public void setLojaNome(String lojaNome) {
        this.lojaNome = lojaNome;
    }

    public Integer getId_loja() {
        return id_loja;
    }

    public void setId_loja(Integer id) {
        this.id_loja = id_loja;
    }
}
