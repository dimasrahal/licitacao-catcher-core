package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.ModalidadeOrigem;

@RepositoryRestResource
public interface ModalidadeOrigemRepository extends CrudRepository<ModalidadeOrigem, Integer> {

    ModalidadeOrigem findByDescricao(String descricao);

    ModalidadeOrigem findByDescricaoEOrigemId(String descricao, int idOrigem);

}
