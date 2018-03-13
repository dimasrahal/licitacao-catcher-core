package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Status;

@RepositoryRestResource
public interface StatusRepository extends CrudRepository<Status, Integer> {

    Status findByDescricao(String descricao);
}
