package br.com.aset.licitacao.catcher.adapter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.aset.licitacao.catcher.adapter.entity.Licitacao;
import br.com.aset.licitacao.catcher.adapter.entity.Origem;

@RepositoryRestResource
public interface LicitacaoRepository extends CrudRepository<Licitacao, Integer> {

    @Query("SELECT a FROM Licitacao a WHERE a.origem = ?1 and LOWER(a.codigoOrigem) = LOWER(?2)")
    public Licitacao findByOrigemAndCodigoOrigem(Origem origem, String codigoOrigem);

}
