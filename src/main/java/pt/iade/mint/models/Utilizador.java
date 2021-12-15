package pt.iade.mint.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="utilizador")
public class Utilizador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizador", nullable = false)
    private Integer idutilizador;

    @Column(name = "utilizador_nome", nullable = false, length = 60)
    private String utilizadorNome;

    @Column(name = "utilizador_regiao", length = 30)
    private String utilizadorRegiao;

    @Column(name = "utilizador_morada", length = 30)
    private String utilizadorMorada;

    @Column(name = "utilizador_codpostal", length = 8)
    private String utilizadorCodpostal;

    @Column(name = "utilizador_sexo", nullable = false, length = 1)
    private String utilizadorSexo;

    @Column(name = "utilizador_anosdata", nullable = false)
    private LocalDate utilizadorAnosdata;

    @Column(name = "utilizador_email", length = 30)
    private String utilizadorEmail;

    @Column(name = "utilizador_pass", length = 30)
    private String utilizadorPass;

    public String getUtilizadorPass() {
        return utilizadorPass;
    }

    public void setUtilizadorPass(String utilizadorPass) {
        this.utilizadorPass = utilizadorPass;
    }

    public String getUtilizadorEmail() {
        return utilizadorEmail;
    }

    public void setUtilizadorEmail(String utilizadorEmail) {
        this.utilizadorEmail = utilizadorEmail;
    }

    public LocalDate getUtilizadorAnosdata() {
        return utilizadorAnosdata;
    }

    public void setUtilizadorAnosdata(LocalDate utilizadorAnosdata) {
        this.utilizadorAnosdata = utilizadorAnosdata;
    }

    public String getUtilizadorSexo() {
        return utilizadorSexo;
    }

    public void setUtilizadorSexo(String utilizadorSexo) {
        this.utilizadorSexo = utilizadorSexo;
    }

    public String getUtilizadorCodpostal() {
        return utilizadorCodpostal;
    }

    public void setUtilizadorCodpostal(String utilizadorCodpostal) {
        this.utilizadorCodpostal = utilizadorCodpostal;
    }

    public String getUtilizadorMorada() {
        return utilizadorMorada;
    }

    public void setUtilizadorMorada(String utilizadorMorada) {
        this.utilizadorMorada = utilizadorMorada;
    }

    public String getUtilizadorRegiao() {
        return utilizadorRegiao;
    }

    public void setUtilizadorRegiao(String utilizadorRegiao) {
        this.utilizadorRegiao = utilizadorRegiao;
    }

    public String getUtilizadorNome() {
        return utilizadorNome;
    }

    public void setUtilizadorNome(String utilizadorNome) {
        this.utilizadorNome = utilizadorNome;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setId(Integer id) {
        this.idutilizador = id;
    }
}
