package br.com.aset.licitacao.catcher.adapter.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
        @NamedQuery(name = "Orgao.findByDescricaoEOrigem", query = "SELECT a FROM Orgao a WHERE a.origem.id = ?1 and LOWER(a.descricao) = LOWER(?2) ")
})
@Table(name = "orgao")
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String orgao;

    private String cnpj;

    private String descricao;

    private String nomeFantasia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_secretaria")
    private Secretaria secretaria;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    @XmlElement
    public void setOrgao(String orgao) {
        this.orgao = orgao;
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

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @XmlElement
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Origem getOrigem() {
        return origem;
    }

    @XmlTransient
    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public String getOrgao() {
        return orgao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @XmlTransient
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    @XmlTransient
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
}
