package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Area;
import br.com.aset.licitacao.catcher.adapter.entity.AreaOrigem;

@RepositoryRestResource
public interface AreaOrigemRepository extends CrudRepository<AreaOrigem, Integer> {

    List<Area> findByDescricao(String descricao);

    AreaOrigem findByDescricaoEOrigem(String descricao, int codigoOrigem);

}
