package br.com.aset.licitacao.catcher.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@NamedQueries({
        @NamedQuery(name = "SubAreaOrigem.findByDescricaoEOrigem", query = "SELECT a FROM SubAreaOrigem a WHERE a.origem.id = ?2 and LOWER(a.descricao) = LOWER(?1) ")
})
@Table(name = "subarea_origem")
public class SubAreaOrigem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo_origem")
    private String codigoOrigem;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    @ManyToOne
    @JoinColumn(name = "id_subarea")
    private SubArea subArea;

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

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

}
