package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.TipoEvento;

@RepositoryRestResource
public interface TipoEventoRepository extends CrudRepository<TipoEvento, Integer> {

    TipoEvento findByDescricao(String descricao);
}
