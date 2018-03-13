package br.com.aset.licitacao.catcher.infra.solr;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimeZone;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

import br.com.aset.licitacao.catcher.adapter.entity.Evento;
import br.com.aset.licitacao.catcher.adapter.entity.Licitacao;
import br.com.aset.licitacao.catcher.adapter.entity.Objeto;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

@Component
public class LicitacaoSolr {

    private HttpSolrServer solr;

    public LicitacaoSolr() {
        String urlString = "http://localhost:8983/solr/content";
        solr = new HttpSolrServer(urlString);
    }

    public void addDocument(Licitacao content) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Collection<SolrInputDocument> listaDocuments = new LinkedList<SolrInputDocument>();
        try {
            /*
             * for (Iterator iterator = licitacoes.iterator(); iterator.hasNext();) {
             * Licitacao content = (Licitacao) iterator.next();
             */

            SolrInputDocument doc = new SolrInputDocument();

            doc.addField("id", content.getId());
            doc.addField("titulo", content.getTitulo());

            doc.addField("status_id", content.getStatus().getId());
            doc.addField("status_descricao", content.getStatus().getDescricao());

            if (content.getArea() != null) {
                doc.addField("area_id", content.getArea().getId());
                doc.addField("area_descricao", content.getArea().getDescricao());
            }
            if (content.getDataAbertura() != null)
                doc.addField("dataAbertura", df.format(content.getDataAbertura()));

            if (content.getDataEntregaEdital() != null)
                doc.addField("dataEntregaEdital", df.format(content.getDataEntregaEdital()));

            if (content.getDataLicitacao() != null)
                doc.addField("dataLicitacao", df.format(content.getDataLicitacao()));

            if (content.getDataPublicacao() != null)
                doc.addField("dataPublicacao", df.format(content.getDataPublicacao()));

            if (content.getDataRecebimentoProposta() != null)
                doc.addField("dataRecebimentoProposta", df.format(content.getDataRecebimentoProposta()));

            if (content.getDepartamento() != null) {
                doc.addField("departamento_id", content.getDepartamento().getId());
                doc.addField("departamento_descricao", content.getDepartamento().getDescricao());
                doc.addField("departamento_cnpj", content.getDepartamento().getCnpj());
            }

            if (content.getEventos() != null && content.getEventos().size() > 0) {

                for (Iterator it = content.getEventos().iterator(); it.hasNext();) {
                    Evento eve = (Evento) it.next();
                    doc.addField("evento_id", eve.getId());
                    if (eve.getSinteseLicitacao() != null && !"".equals(eve.getSinteseLicitacao())) {
                        if (eve.getSinteseLicitacao().length() > 1000) {
                            Iterable<String> result = Splitter.fixedLength(1000).split(eve.getSinteseLicitacao());
                            String[] parts = Iterables.toArray(result, String.class);
                            for (int i = 0; i < parts.length; i++) {
                                doc.addField("evento_sintese", parts[i]);
                            }
                        } else {
                            doc.addField("evento_sintese", eve.getSinteseLicitacao());
                        }
                    }
                    if (eve.getDataAberturaSessao() != null)
                        doc.addField("evento_dataAberturaSessao", df.format(eve.getDataAberturaSessao()));

                    if (eve.getDataPublicacao() != null)
                        doc.addField("evento_dataPublicacao", df.format(eve.getDataPublicacao()));

                    if (eve.getTipoEvento() != null) {
                        doc.addField("evento_tipo_evento_id", eve.getTipoEvento().getId());
                        doc.addField("evento_tipo_evento_descricao", eve.getTipoEvento().getDescricao());
                    }
                }
            }
            if (content.getLocalExecucao() != null) {
                doc.addField("localExecucao_id", content.getLocalExecucao().getId());
                doc.addField("localExecucao_descricao", content.getLocalExecucao().getDescricao());
            }
            if (content.getLocalidade() != null) {
                doc.addField("localidade_id", content.getLocalidade().getId());
                doc.addField("localidade_descricao", content.getLocalidade().getDescricao());
            }
            if (content.getModalidade() != null) {
                doc.addField("modalidade_id", content.getModalidade().getId());
                doc.addField("modalidade_descricao", content.getModalidade().getDescricao());
            }

            doc.addField("notaReserva", content.getNotaReserva());
            doc.addField("numero", content.getNumero());

            if (content.getObjetos() != null && content.getObjetos().size() > 0) {

                for (Iterator it = content.getObjetos().iterator(); it.hasNext();) {
                    Objeto eve = (Objeto) it.next();
                    doc.addField("objeto_id", eve.getId());
                    doc.addField("objeto_descricao", eve.getDescricao());
                }
            }

            doc.addField("ofertaCompra", content.getOfertaCompra());
            if (content.getOrgao() != null) {
                doc.addField("orgao_id", content.getOrgao().getId());
                doc.addField("orgao_nomeFantasia", content.getOrgao().getNomeFantasia());
            }

            doc.addField("processo", content.getProcesso());

            if (content.getSecretaria() != null) {
                doc.addField("secretaria_id", content.getSecretaria().getId());
                doc.addField("secretaria_descricao", content.getSecretaria().getDescricao());
            }
            if (content.getSubArea() != null) {
                doc.addField("subarea_id", content.getSubArea().getId());
                doc.addField("subarea_descricao", content.getSubArea().getDescricao());
            }
            if (content.getTipoLicitacao() != null) {
                doc.addField("tipoLicitacao_id", content.getTipoLicitacao().getId());
                doc.addField("tipoLicitacao_descricao", content.getTipoLicitacao().getDescricao());
            }
            solr.add(doc);
            // listaDocuments.add(doc);
            // }

            solr.commit();
        } catch (SolrServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
