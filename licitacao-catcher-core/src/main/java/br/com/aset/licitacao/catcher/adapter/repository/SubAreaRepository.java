package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.SubArea;

@RepositoryRestResource
public interface SubAreaRepository extends CrudRepository<SubArea, Integer> {

    public List<SubArea> findByDescricao(String descricao);

    public List<SubArea> findByAreaId(int idArea);

    public SubArea findByAreaESubAreaDescricao(int area, String descricao);

}
