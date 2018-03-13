package br.com.aset.licitacao.catcher.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name = "SubArea.findByAreaESubAreaDescricao", query = "SELECT a.id,a.descricao,a.codigo_origem FROM SubArea a WHERE a.id_area = ?1 and LOWER(a.descricao) = LOWER(?2) ", resultClass = SubArea.class),
        @NamedNativeQuery(name = "SubArea.findByAreaId", query = "SELECT a.id,a.descricao,a.codigo_origem FROM SubArea a WHERE a.id_area = ?1", resultClass = SubArea.class)
})
@Table(name = "subarea")
public class SubArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "descricao")
    private String descricao;

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

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
