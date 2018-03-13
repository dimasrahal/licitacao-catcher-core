package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.TipoLicitacao;

@RepositoryRestResource
public interface TipoLicitacaoRepository extends CrudRepository<TipoLicitacao, Integer> {

    TipoLicitacao findByDescricao(String descricao);
}
