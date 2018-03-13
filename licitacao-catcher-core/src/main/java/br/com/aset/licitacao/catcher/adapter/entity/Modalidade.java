package br.com.aset.licitacao.catcher.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "modalidade")
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "is_ata_registro_preco")
    private boolean isAtaRegistroPreco;

    @Column(name = "codigo_origem")
    private String codigoOrigem;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    @XmlElement
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtaRegistroPreco() {
        return isAtaRegistroPreco;
    }

    @XmlElement
    public void setAtaRegistroPreco(boolean isAtaRegistroPreco) {
        this.isAtaRegistroPreco = isAtaRegistroPreco;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
