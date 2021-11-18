package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "regiao")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regiao", nullable = false)
    private Integer id_regiao;

    @Column(name = "nome_regiao", nullable = false, length = 30)
    private String nomeRegiao;

    @Column(name = "id_pais", nullable = false)
    private Integer idPais;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Integer getId_regiao() {
        return id_regiao;
    }

    public void setId_regiao(Integer id_regiao) {
        this.id_regiao = id_regiao;
    }
}
