package br.com.aset.licitacao.catcher.adapter.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.aset.licitacao.catcher.infra.file.DateAdapter;
import br.com.aset.licitacao.catcher.infra.file.TimestampAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @Column(name = "data_publicacao")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dataPublicacao;

    @Column(name = "data_abertura_sessao")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp dataAberturaSessao;

    @Column(name = "codigo_origem")
    private String codigoOrigem;

    @Column(name = "id_licitacao")
    private int idLicitacao;

    @Transient
    private String sinteseLicitacao;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public Timestamp getDataAberturaSessao() {
        return dataAberturaSessao;
    }

    public void setDataAberturaSessao(Timestamp dataAberturaSessao) {
        this.dataAberturaSessao = dataAberturaSessao;
    }

    public String getSinteseLicitacao() {
        return sinteseLicitacao;
    }

    public void setSinteseLicitacao(String sinteseLicitacao) {
        this.sinteseLicitacao = sinteseLicitacao;
    }

    public int getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(int idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

}
