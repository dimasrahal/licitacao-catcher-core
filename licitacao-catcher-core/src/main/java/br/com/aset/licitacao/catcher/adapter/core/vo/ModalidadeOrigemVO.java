package br.com.aset.licitacao.catcher.adapter.core.vo;


public class ModalidadeOrigemVO {

    private int id;

    private String descricao;

    private String codigoOrigem;

    private OrigemVO origem;

    private ModalidadeVO modalidade;

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

    public ModalidadeVO getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeVO modalidade) {
        this.modalidade = modalidade;
    }

}
