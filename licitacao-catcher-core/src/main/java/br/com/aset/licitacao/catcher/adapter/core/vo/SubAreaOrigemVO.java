package br.com.aset.licitacao.catcher.adapter.core.vo;


public class SubAreaOrigemVO {

    private int id;

    private String descricao;

    private String codigoOrigem;

    private OrigemVO origem;

    private SubAreaVO subArea;

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

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public OrigemVO getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemVO origem) {
        this.origem = origem;
    }

    public SubAreaVO getSubArea() {
        return subArea;
    }

    public void setSubArea(SubAreaVO subArea) {
        this.subArea = subArea;
    }

}
