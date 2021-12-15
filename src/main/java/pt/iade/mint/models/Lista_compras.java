package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "lista_compras")
public class Lista_compras {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista", nullable = false)
    private Integer idlista;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produtor", nullable = false)
    private Produtor idProdutor;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "precot", nullable = false)
    private Integer precot;

    public Integer getPrecot() {
        return precot;
    }

    public void setPrecot(Integer precot) {
        this.precot = precot;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produtor getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdlista() {
        return idlista;
    }

    public void setId(Integer id) {
        this.idlista = id;
    }
}
