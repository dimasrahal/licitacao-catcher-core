package br.com.aset.licitacao.catcher.infra.solr;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Component;

import br.com.aset.licitacao.catcher.adapter.form.LicitacaoForm;

@Component
public class SolrLicitacaoClient {

    private static String url = "http://localhost:8983/solr/content";

    private List<LicitacaoForm> contents;

    /*
     * public static void main(String[] args) {
     * 
     * SolrContentClient client = new SolrContentClient();
     * client.findByOrgao("DOEMC");
     * }
     */

    public Iterable<LicitacaoForm> getContentByNumeroProcesso(String numerProcesso) {
        List<LicitacaoForm> licitacoes = new LinkedList<LicitacaoForm>();
        HttpSolrServer solrServer = new HttpSolrServer(url);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.addFilterQuery("numero:" + numerProcesso);
        query.setRows(50);
        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
        }
        if (response != null) {
            SolrDocumentList list = response.getResults();
            parseDocumentToObject(licitacoes, list);
        }
        return licitacoes;
    }

    public Iterable<LicitacaoForm> findByOrgaoId(String orgao) {
        List<LicitacaoForm> licitacoes = new LinkedList<LicitacaoForm>();
        HttpSolrServer solrServer = new HttpSolrServer(url);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.addFilterQuery("orgao_id:" + orgao);
        query.setRows(100);
        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
        }
        if (response != null) {
            SolrDocumentList list = response.getResults();
            parseDocumentToObject(licitacoes, list);
        }
        return licitacoes;
    }

    public Iterable<LicitacaoForm> findAll() {
        List<LicitacaoForm> licitacoes = new LinkedList<LicitacaoForm>();
        HttpSolrServer solrServer = new HttpSolrServer(url);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setSort("dataPublicacao", ORDER.desc);
        query.setRows(50);
        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
        }

        SolrDocumentList list = response.getResults();
        parseDocumentToObject(licitacoes, list);
        return licitacoes;
    }

    public Iterable<LicitacaoForm> getContentByParams(String area, String subArea, String secretaria, String departamento, String orgao,
            String localidade, String modalidade, String status, String numero, String texto) {
        List<LicitacaoForm> contents = new LinkedList<LicitacaoForm>();
        HttpSolrServer solrServer = new HttpSolrServer(url);
        StringBuffer querySBF = new StringBuffer();
        SolrQuery query = new SolrQuery();

        if (orgao != null && !"".equals(orgao)) {
            querySBF.append("orgao_id:" + orgao);
        }

        if (numero != null && !"".equals(numero)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND numero:" + numero);
            } else {
                querySBF.append("numero:" + numero);
            }
        }
        if (area != null && !"".equals(area)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND area_id:" + area);
            } else {
                querySBF.append("area_id:" + area);
            }
        }
        if (subArea != null && !"".equals(subArea)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND subarea_id:" + subArea);
            } else {
                querySBF.append("subarea_id:" + subArea);
            }
        }
        if (secretaria != null && !"".equals(secretaria)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND secretaria_id:" + secretaria);
            } else {
                querySBF.append("secretaria_id:" + secretaria);
            }
        }
        if (departamento != null && !"".equals(departamento)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND departamento_id:" + departamento);
            } else {
                querySBF.append("departamento_id:" + departamento);
            }
        }
        if (status != null && !"".equals(status)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND status_id:" + status);
            } else {
                querySBF.append("status_id:" + status);
            }
        }
        if (localidade != null && !"".equals(localidade)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND localidade_id:" + localidade);
            } else {
                querySBF.append("localidade_id:" + localidade);
            }
        }
        if (modalidade != null && !"".equals(modalidade)) {
            if (!"".equals(querySBF.toString())) {
                querySBF.append(" AND modalidade_id:" + modalidade);
            } else {
                querySBF.append("modalidade_id:" + modalidade);
            }
        }

        if (texto != null && !"".equals(texto)) {
            query.setQuery("evento_sintese:" + texto);
        } else {
            query.setQuery(querySBF.toString());
        }

        query.setRows(50);
        query.setSort("dataPublicacao", ORDER.desc);
        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
        }

        SolrDocumentList list = response.getResults();
        parseDocumentToObject(contents, list);
        return contents;
    }

    private void parseDocumentToObject(List<LicitacaoForm> contents,
            SolrDocumentList list) {
        this.contents = contents;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            SolrDocument solrDocument = (SolrDocument) iterator.next();
            LicitacaoForm licitacao = new LicitacaoForm();
            licitacao.setId(Integer.parseInt((String) solrDocument.getFieldValue("id")));
            if (solrDocument.getFieldValue("orgao") != null) {
                licitacao.orgao_Id = ((String) solrDocument.getFieldValue("orgao_id"));
                licitacao.orgao_nomeFantasia = ((String) solrDocument.getFieldValue("orgao_nomeFantasia"));
            }
            licitacao.area_id = ((String) solrDocument.getFieldValue("area_id"));
            licitacao.area_descricao = ((String) solrDocument.getFieldValue("area_descricao"));

            licitacao.status_descricao = ((String) solrDocument.getFieldValue("status_descricao"));

            if (solrDocument.getFieldValue("dataAbertura") != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(((Date) solrDocument.getFieldValue("dataAbertura")));
                String dataAbt = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
                licitacao.dataAbertura = (Date) solrDocument.getFieldValue("dataAbertura");
            }

            if (solrDocument.getFieldValue("dataLicitacao") != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(((Date) solrDocument.getFieldValue("dataLicitacao")));
                String dataLct = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
                licitacao.dataLicitacao = (Date) solrDocument.getFieldValue("dataLicitacao");
            }

            if (solrDocument.getFieldValue("dataPublicacao") != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(((Date) solrDocument.getFieldValue("dataPublicacao")));
                String dataPub = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
                licitacao.dataPublicacao = (Date) solrDocument.getFieldValue("dataPublicacao");
            }
            licitacao.localExecucao_descricao = ((String) solrDocument.getFieldValue("localExecucao_descricao"));
            licitacao.modalidade_descricao = ((String) solrDocument.getFieldValue("modalidade_descricao"));
            licitacao.modalidade_id = ((String) solrDocument.getFieldValue("modalidade_id"));
            licitacao.numero = ((String) solrDocument.getFieldValue("numero"));
            if (solrDocument.getFieldValue("objeto_descricao") != null) {
                List listaObjetosDescricao = (List) solrDocument.getFieldValue("objeto_descricao");
                StringBuffer sbf = new StringBuffer();
                for (Iterator iterator2 = listaObjetosDescricao.iterator(); iterator2.hasNext();) {
                    String object = (String) iterator2.next();
                    sbf.append(object);
                }
                licitacao.objeto_descricao = sbf.toString();
            }

            licitacao.processo = ((String) solrDocument.getFieldValue("processo"));
            licitacao.tipoLicitacao_descricao = ((String) solrDocument.getFieldValue("tipoLicitacao_descricao"));

            contents.add(licitacao);
        }
    }

    public LicitacaoForm getLicitacaoById(int id) {
        List<LicitacaoForm> contents = new LinkedList<LicitacaoForm>();
        HttpSolrServer solrServer = new HttpSolrServer(url);
        SolrQuery query = new SolrQuery();
        query.setQuery("id:" + id);
        query.setRows(1);
        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
        }

        SolrDocumentList list = response.getResults();
        parseDocumentToObject(contents, list);
        return contents.get(0);
    }
}
