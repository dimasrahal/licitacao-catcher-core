package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Origem;

@RepositoryRestResource
public interface OrigemRepository extends CrudRepository<Origem, Integer> {

    Origem findByDescricao(String descricao);

}
