package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "favoritos")
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favoritos", nullable = false)
    private Integer id_favoritos;

    @Column(name = "id_utilizador", nullable = false)
    private Integer idUtilizador;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getId_favoritos() {
        return id_favoritos;
    }

    public void setId_favoritos(Integer id_favoritos) {
        this.id_favoritos = id_favoritos;
    }
}
