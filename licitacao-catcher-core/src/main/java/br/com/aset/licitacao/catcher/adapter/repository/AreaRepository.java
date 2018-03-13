package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Area;

@RepositoryRestResource
public interface AreaRepository extends CrudRepository<Area, Integer> {

    List<Area> findByDescricao(String descricao);

    Area findByDescricaoEOrigem(int idOrigem, String descricao);

}
