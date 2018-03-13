package br.com.aset.licitacao.catcher.adapter.core.vo;

import java.util.List;

public class SecretariaVO {

    private int id;

    private String descricao;

    private String nomeFantasia;

    private String cnpj;

    private String codigoOrigem;

    private OrigemVO origem;

    private List<DepartamentoVO> departamentos;

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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<DepartamentoVO> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoVO> departamentos) {
        this.departamentos = departamentos;
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

}
