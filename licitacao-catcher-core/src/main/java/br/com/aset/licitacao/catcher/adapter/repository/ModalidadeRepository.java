package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Modalidade;

@RepositoryRestResource
public interface ModalidadeRepository extends CrudRepository<Modalidade, Integer> {

    Modalidade findByDescricao(String descricao);
}
