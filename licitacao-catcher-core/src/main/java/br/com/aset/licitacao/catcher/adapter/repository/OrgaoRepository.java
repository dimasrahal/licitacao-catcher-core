package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Orgao;

@RepositoryRestResource
public interface OrgaoRepository extends CrudRepository<Orgao, Integer> {

    List<Orgao> findByOrgao(String orgao);

    Orgao findByOrigemIdAndNomeFantasia(int idOrigem, String nomeFantasia);

}
