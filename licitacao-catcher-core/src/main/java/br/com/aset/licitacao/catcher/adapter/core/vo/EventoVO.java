package br.com.aset.licitacao.catcher.adapter.core.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class EventoVO {

    private int id;

    private TipoEventoVO tipoEvento;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataPublicacao;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataAberturaSessao;

    private String codigoOrigem;

    private String sinteseLicitacao;

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

    public TipoEventoVO getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoVO tipoEvento) {
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

    public Date getDataAberturaSessao() {
        return dataAberturaSessao;
    }

    public void setDataAberturaSessao(Date dataAberturaSessao) {
        this.dataAberturaSessao = dataAberturaSessao;
    }

    public String getSinteseLicitacao() {
        return sinteseLicitacao;
    }

    public void setSinteseLicitacao(String sinteseLicitacao) {
        this.sinteseLicitacao = sinteseLicitacao;
    }

}
