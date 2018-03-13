package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.SubAreaOrigem;

@RepositoryRestResource
public interface SubAreaOrigemRepository extends CrudRepository<SubAreaOrigem, Integer> {

    List<SubAreaOrigem> findByDescricao(String descricao);

    public List<SubAreaOrigem> findByDescricaoEOrigem(String descricao, int origem);

}
