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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
        @NamedQuery(name = "AreaOrigem.findByDescricaoEOrigem", query = "SELECT a FROM AreaOrigem a WHERE a.origem.id = ?2 and LOWER(a.descricao) = LOWER(?1) ")
})
@Table(name = "area_origem")
public class AreaOrigem {

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
    @JoinColumn(name = "id_area")
    private Area area;

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

    public Origem getOrigem() {
        return origem;
    }

    @XmlTransient
    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
