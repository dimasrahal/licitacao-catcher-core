package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.LocalExecucao;

@RepositoryRestResource
public interface LocalExecucaoRepository extends CrudRepository<LocalExecucao, Integer> {

    LocalExecucao findByDescricao(String descricao);
}
