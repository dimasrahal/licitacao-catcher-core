package br.com.aset.licitacao.catcher.adapter.core.vo;


public class ModalidadeVO {

    private int id;

    private String descricao;

    private boolean isAtaRegistroPreco;

    private String codigoOrigem;

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

    public boolean isAtaRegistroPreco() {
        return isAtaRegistroPreco;
    }

    public void setAtaRegistroPreco(boolean isAtaRegistroPreco) {
        this.isAtaRegistroPreco = isAtaRegistroPreco;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
