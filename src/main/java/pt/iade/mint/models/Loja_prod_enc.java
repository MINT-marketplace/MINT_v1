package pt.iade.mint.models;

import javax.persistence.*;

@Entity
@Table(name = "loja_prod_enc")
public class Loja_prod_enc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja_prod_enc", nullable = false)
    private Integer id_loja_prod_enc;

    @Column(name = "id_lista", nullable = false)
    private Integer idLista;

    @Column(name = "id_encomenda", nullable = false)
    private Integer idEncomenda;

    public Integer getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Integer idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getId() {
        return id_loja_prod_enc;
    }

    public void setId_loja_prod_enc(Integer id_loja_prod_enc) {
        this.id_loja_prod_enc = id_loja_prod_enc;
    }
}
