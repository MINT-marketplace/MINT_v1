package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "produtor")
public class Produtor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja", nullable = false)
    private Integer idloja;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_utilizador", nullable = false)
    private Utilizador idUtilizador;

    @Column(name = "loja_nome", nullable = false, length = 60)
    private String lojaNome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_regiao", nullable = false)
    private Regiao idRegiao;

    public Regiao getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Regiao idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getLojaNome() {
        return lojaNome;
    }

    public void setLojaNome(String lojaNome) {
        this.lojaNome = lojaNome;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdloja() {
        return idloja;
    }

    public void setId(Integer id) {
        this.idloja = id;
    }
}
