package br.com.aset.licitacao.catcher.adapter.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
        @NamedQuery(name = "Area.findByDescricaoEOrigem", query = "SELECT a FROM Area a WHERE a.origem.id = ?1 and LOWER(a.descricao) = LOWER(?2) ")
})
@Table(name = "area")
public class Area {

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

    @XmlTransient
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_area")
    public List<SubArea> subAreas = new LinkedList<SubArea>();

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

    public List<SubArea> getSubAreas() {
        return subAreas;
    }

    @XmlTransient
    public void setSubAreas(List<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
