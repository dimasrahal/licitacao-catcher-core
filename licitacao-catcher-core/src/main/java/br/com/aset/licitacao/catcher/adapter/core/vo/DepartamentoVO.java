package br.com.aset.licitacao.catcher.adapter.core.vo;


public class DepartamentoVO {

    private int id;

    private String descricao;

    private String cnpj;

    private String codigoOrigem;

    private SecretariaVO secretaria;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public SecretariaVO getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaVO secretaria) {
        this.secretaria = secretaria;
    }

}
