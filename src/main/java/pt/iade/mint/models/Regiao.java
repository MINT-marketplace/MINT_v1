package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "regiao")
public class Regiao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regiao", nullable = false)
    private Integer idregiao;

    @Column(name = "nome_regiao", nullable = false, length = 30)
    private String nomeRegiao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais idPais;

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Integer getIdregiao() {
        return idregiao;
    }

    public void setId(Integer id) {
        this.idregiao = id;
    }
}
