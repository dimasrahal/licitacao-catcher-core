package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Evento;

@RepositoryRestResource
public interface EventoRepository extends CrudRepository<Evento, Integer> {

    Evento findByCodigoOrigem(String codigoOrigem);
}
