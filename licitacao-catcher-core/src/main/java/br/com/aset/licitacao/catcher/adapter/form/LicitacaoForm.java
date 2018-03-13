package br.com.aset.licitacao.catcher.adapter.form;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.com.aset.licitacao.catcher.adapter.entity.Area;
import br.com.aset.licitacao.catcher.adapter.entity.Departamento;
import br.com.aset.licitacao.catcher.adapter.entity.LocalExecucao;
import br.com.aset.licitacao.catcher.adapter.entity.Modalidade;
import br.com.aset.licitacao.catcher.adapter.entity.Orgao;
import br.com.aset.licitacao.catcher.adapter.entity.Secretaria;
import br.com.aset.licitacao.catcher.adapter.entity.Status;
import br.com.aset.licitacao.catcher.adapter.entity.SubArea;

public class LicitacaoForm {

    public int id;

    public String numero;

    public Date dataLicitacao;

    public Date dataPublicacao;

    public Date dataAbertura;

    private Date dataEntregaEdital;

    private Date dataRecebimentoProposta;

    public String orgao_nomeFantasia;

    public String orgao_Id;

    public String area_id;

    public Area area;

    public List<SubArea> subAreas = new LinkedList<SubArea>();

    public SubArea subArea;

    public Orgao orgao;

    public Modalidade modalidade;

    public LocalExecucao localidade;

    public Status status;

    public String status_descricao;

    public Secretaria secretaria;

    public Departamento departamento;

    public String area_descricao;

    public String localExecucao_descricao;

    public String modalidade_descricao;

    public String modalidade_id;

    public String objeto_descricao;

    public String tipoLicitacao_descricao;

    public String processo;

    public String sintese;

    public void selectedSubAreas() {
        subAreas = area.getSubAreas();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Date getDataLicitacao() {
        return dataLicitacao;
    }

    public void setDataLicitacao(Date dataLicitacao) {
        this.dataLicitacao = dataLicitacao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEntregaEdital() {
        return dataEntregaEdital;
    }

    public void setDataEntregaEdital(Date dataEntregaEdital) {
        this.dataEntregaEdital = dataEntregaEdital;
    }

    public Date getDataRecebimentoProposta() {
        return dataRecebimentoProposta;
    }

    public void setDataRecebimentoProposta(Date dataRecebimentoProposta) {
        this.dataRecebimentoProposta = dataRecebimentoProposta;
    }

    public String getOrgao_nomeFantasia() {
        return orgao_nomeFantasia;
    }

    public void setOrgao_nomeFantasia(String orgao_nomeFantasia) {
        this.orgao_nomeFantasia = orgao_nomeFantasia;
    }

    public String getOrgao_Id() {
        return orgao_Id;
    }

    public void setOrgao_Id(String orgao_Id) {
        this.orgao_Id = orgao_Id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getArea_descricao() {
        return area_descricao;
    }

    public void setArea_descricao(String area_descricao) {
        this.area_descricao = area_descricao;
    }

    public String getLocalExecucao_descricao() {
        return localExecucao_descricao;
    }

    public void setLocalExecucao_descricao(String localExecucao_descricao) {
        this.localExecucao_descricao = localExecucao_descricao;
    }

    public String getModalidade_descricao() {
        return modalidade_descricao;
    }

    public void setModalidade_descricao(String modalidade_descricao) {
        this.modalidade_descricao = modalidade_descricao;
    }

    public String getModalidade_id() {
        return modalidade_id;
    }

    public void setModalidade_id(String modalidade_id) {
        this.modalidade_id = modalidade_id;
    }

    public String getObjeto_descricao() {
        return objeto_descricao;
    }

    public void setObjeto_descricao(String objeto_descricao) {
        this.objeto_descricao = objeto_descricao;
    }

    public String getTipoLicitacao_descricao() {
        return tipoLicitacao_descricao;
    }

    public void setTipoLicitacao_descricao(String tipoLicitacao_descricao) {
        this.tipoLicitacao_descricao = tipoLicitacao_descricao;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public LocalExecucao getLocalidade() {
        return localidade;
    }

    public void setLocalidade(LocalExecucao localidade) {
        this.localidade = localidade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(List<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getSintese() {
        return sintese;
    }

    public void setSintese(String sintese) {
        this.sintese = sintese;
    }

    public String getStatus_descricao() {
        return status_descricao;
    }

    public void setStatus_descricao(String status_descricao) {
        this.status_descricao = status_descricao;
    }

}
