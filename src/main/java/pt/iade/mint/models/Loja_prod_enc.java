package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "loja_prod_enc")
public class Loja_prod_enc {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja_prod_enc", nullable = false)
    private Integer idlojaprodenc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_lista", nullable = false)
    private Lista_compras idLista;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_encomenda", nullable = false)
    private Encomenda idEncomenda;

    public Encomenda getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Encomenda idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Lista_compras getIdLista() {
        return idLista;
    }

    public void setIdLista(Lista_compras idLista) {
        this.idLista = idLista;
    }

    public Integer getIdlojaprodenc() {
        return idlojaprodenc;
    }

    public void setId(Integer id) {
        this.idlojaprodenc = id;
    }
}
