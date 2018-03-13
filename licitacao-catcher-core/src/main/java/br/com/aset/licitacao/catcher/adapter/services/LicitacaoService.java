package br.com.aset.licitacao.catcher.adapter.services;

import br.com.aset.licitacao.catcher.adapter.core.vo.LicitacaoVO;
import br.com.aset.licitacao.catcher.adapter.form.LicitacaoForm;

public interface LicitacaoService {

    Iterable<LicitacaoForm> listAllContents();

    br.com.aset.licitacao.catcher.adapter.entity.Licitacao getLicitacaoById(int id);

    Iterable<LicitacaoForm> findByOrgaoId(String orgao);

    Iterable<LicitacaoForm> getContentByNumeroProcesso(String numeroProcesso);

    public Iterable<LicitacaoForm> getContentByParams(String area, String subArea, String secretaria, String departamento, String orgao,
            String localidade, String modalidade, String status, String numero, String texto);

    void processarLicitacao(LicitacaoVO licitacao);
}
