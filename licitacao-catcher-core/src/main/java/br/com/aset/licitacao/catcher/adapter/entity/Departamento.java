package br.com.aset.licitacao.catcher.adapter.entity;

import javax.persistence.CascadeType;
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
        @NamedQuery(name = "Departamento.findBySecretariaEDepartamentoDescricao", query = "SELECT a FROM Departamento a WHERE a.secretaria.id = ?1 and LOWER(a.descricao) = LOWER(?2) "),
        @NamedQuery(name = "Departamento.findBySecretariaECodigoOrigem", query = "SELECT a FROM Departamento a WHERE a.secretaria.id = ?1 and a.codigoOrigem = ?2 ")
})
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "codigo_origem")
    private String codigoOrigem;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_secretaria")
    private Secretaria secretaria;

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

    public String getCnpj() {
        return cnpj;
    }

    @XmlElement
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    @XmlTransient
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

}
