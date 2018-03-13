package br.com.aset.licitacao.catcher.adapter.core.vo;


public class OrgaoVO {

    private int id;

    private String orgao;

    private String cnpj;

    private String descricao;

    private String nomeFantasia;

    private DepartamentoVO departamento;

    private SecretariaVO secretaria;

    private OrigemVO origem;

    public void setOrgao(String orgao) {
        this.orgao = orgao;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public OrigemVO getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemVO origem) {
        this.origem = origem;
    }

    public String getOrgao() {
        return orgao;
    }

    public DepartamentoVO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoVO departamento) {
        this.departamento = departamento;
    }

    public SecretariaVO getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaVO secretaria) {
        this.secretaria = secretaria;
    }
}
