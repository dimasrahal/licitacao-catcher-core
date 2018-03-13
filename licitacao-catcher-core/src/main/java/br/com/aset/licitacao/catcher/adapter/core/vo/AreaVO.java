package br.com.aset.licitacao.catcher.adapter.core.vo;

import java.util.List;

public class AreaVO {

    private int id;

    private String descricao;

    private String codigoOrigem;

    private OrigemVO origem;

    private List<SubAreaVO> subAreas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<SubAreaVO> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(List<SubAreaVO> subAreas) {
        this.subAreas = subAreas;
    }

    public OrigemVO getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemVO origem) {
        this.origem = origem;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
