package br.com.aset.licitacao.catcher.adapter.entity;

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
        @NamedQuery(name = "Secretaria.findByDescricaoEOrigem", query = "SELECT a FROM Secretaria a WHERE a.origem.id = ?1 and LOWER(a.descricao) = LOWER(?2) "),
        @NamedQuery(name = "Secretaria.findByOrigemECodigoOrigem", query = "SELECT a FROM Secretaria a WHERE a.origem.id = ?1 and a.codigoOrigem = ?2 ")
})
@Table(name = "secretaria")
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "codigo_origem")
    private String codigoOrigem;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_secretaria")
    private List<Departamento> departamentos;

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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @XmlElement
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    @XmlElement
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    @XmlTransient
    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    @XmlElement
    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public Origem getOrigem() {
        return origem;
    }

    @XmlTransient
    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

}
