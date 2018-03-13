package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Secretaria;

@RepositoryRestResource
public interface SecretariaRepository extends CrudRepository<Secretaria, Integer> {

    List<Secretaria> findByDescricao(String descricao);

    Secretaria findByDescricaoEOrigem(int idOrigem, String descricao);

    Secretaria findByOrigemECodigoOrigem(int idOrigem, String codigoOrigem);

    Secretaria findById(int id);
}
