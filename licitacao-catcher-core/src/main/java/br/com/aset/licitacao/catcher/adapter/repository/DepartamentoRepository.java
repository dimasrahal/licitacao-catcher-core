package br.com.aset.licitacao.catcher.adapter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Departamento;

@RepositoryRestResource
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {

    List<Departamento> findByDescricao(String descricao);

    List<Departamento> findBySecretariaEDepartamentoDescricao(int idSecretaria, String descricao);

    Departamento findBySecretariaECodigoOrigem(int idSecretaria, String codigoOrigem);

}
