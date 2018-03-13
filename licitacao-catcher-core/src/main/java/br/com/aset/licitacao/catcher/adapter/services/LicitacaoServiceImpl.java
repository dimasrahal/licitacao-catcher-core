package br.com.aset.licitacao.catcher.adapter.services;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aset.licitacao.catcher.adapter.core.vo.EventoVO;
import br.com.aset.licitacao.catcher.adapter.core.vo.LicitacaoVO;
import br.com.aset.licitacao.catcher.adapter.core.vo.ObjetoVO;
import br.com.aset.licitacao.catcher.adapter.entity.Area;
import br.com.aset.licitacao.catcher.adapter.entity.AreaOrigem;
import br.com.aset.licitacao.catcher.adapter.entity.Departamento;
import br.com.aset.licitacao.catcher.adapter.entity.Evento;
import br.com.aset.licitacao.catcher.adapter.entity.Licitacao;
import br.com.aset.licitacao.catcher.adapter.entity.LocalExecucao;
import br.com.aset.licitacao.catcher.adapter.entity.Modalidade;
import br.com.aset.licitacao.catcher.adapter.entity.ModalidadeOrigem;
import br.com.aset.licitacao.catcher.adapter.entity.Objeto;
import br.com.aset.licitacao.catcher.adapter.entity.Orgao;
import br.com.aset.licitacao.catcher.adapter.entity.Origem;
import br.com.aset.licitacao.catcher.adapter.entity.Secretaria;
import br.com.aset.licitacao.catcher.adapter.entity.Status;
import br.com.aset.licitacao.catcher.adapter.entity.SubArea;
import br.com.aset.licitacao.catcher.adapter.entity.SubAreaOrigem;
import br.com.aset.licitacao.catcher.adapter.entity.TipoEvento;
import br.com.aset.licitacao.catcher.adapter.entity.TipoLicitacao;
import br.com.aset.licitacao.catcher.adapter.form.LicitacaoForm;
import br.com.aset.licitacao.catcher.adapter.model.StatusEnum;
import br.com.aset.licitacao.catcher.adapter.repository.AreaOrigemRepository;
import br.com.aset.licitacao.catcher.adapter.repository.AreaRepository;
import br.com.aset.licitacao.catcher.adapter.repository.DepartamentoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.EventoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.LicitacaoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.LocalExecucaoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.ModalidadeOrigemRepository;
import br.com.aset.licitacao.catcher.adapter.repository.ModalidadeRepository;
import br.com.aset.licitacao.catcher.adapter.repository.OrgaoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.OrigemRepository;
import br.com.aset.licitacao.catcher.adapter.repository.SecretariaRepository;
import br.com.aset.licitacao.catcher.adapter.repository.StatusRepository;
import br.com.aset.licitacao.catcher.adapter.repository.SubAreaOrigemRepository;
import br.com.aset.licitacao.catcher.adapter.repository.SubAreaRepository;
import br.com.aset.licitacao.catcher.adapter.repository.TipoEventoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.TipoLicitacaoRepository;
import br.com.aset.licitacao.catcher.infra.file.XmlUtil;
import br.com.aset.licitacao.catcher.infra.solr.LicitacaoSolr;
import br.com.aset.licitacao.catcher.infra.solr.SolrLicitacaoClient;

@Service
public class LicitacaoServiceImpl implements LicitacaoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SolrLicitacaoClient client;

    @Autowired
    LicitacaoSolr serverSolr;

    @Autowired
    LicitacaoRepository licitacaoRepo;

    @Autowired
    OrigemRepository oriRP;

    @Autowired
    AreaRepository areaRP;

    @Autowired
    SubAreaRepository subRP;

    @Autowired
    DepartamentoRepository departamentoRP;

    @Autowired
    OrgaoRepository orgaoRP;

    @Autowired
    SecretariaRepository secretariaRP;

    @Autowired
    ModalidadeRepository modalidadeRP;

    @Autowired
    LocalExecucaoRepository localExecucaoRP;

    @Autowired
    TipoEventoRepository tipoEventoRP;

    @Autowired
    TipoLicitacaoRepository tipoLicitacaoRP;

    @Autowired
    XmlUtil infraXml;

    @Autowired
    EventoRepository eventoRP;

    @Autowired
    StatusRepository statusRP;

    @Autowired
    AreaOrigemRepository areaOrigemRP;

    @Autowired
    SubAreaOrigemRepository subAreaOrigemRP;

    @Autowired
    ModalidadeOrigemRepository modalidadeOrigemRepository;

    static Pattern pat = Pattern.compile(".*\\s-\\s(\\w.*)");

    public Iterable<LicitacaoForm> listAllContents() {
        return client.findAll();
    }

    public br.com.aset.licitacao.catcher.adapter.entity.Licitacao getLicitacaoById(int id) {
        br.com.aset.licitacao.catcher.adapter.entity.Licitacao licitacaoEntity = licitacaoRepo.findOne(id);
        licitacaoEntity.getArea();
        licitacaoEntity.getEventos();
        licitacaoEntity.getLocalExecucao();
        licitacaoEntity.getModalidade();
        licitacaoEntity.getObjetos();
        licitacaoEntity.getOrgao();
        licitacaoEntity.getSubArea();
        licitacaoEntity.getTipoLicitacao();

        Licitacao licitaSintese = infraXml.getXML(id);
        if (licitaSintese != null) {
            if (licitaSintese.getEventos() != null)
                licitacaoEntity.setEventos(licitaSintese.getEventos());
        } else {
            licitacaoEntity.setEventos(null);
        }

        return licitacaoEntity;
    }

    public Iterable<LicitacaoForm> findByOrgaoId(String orgao) {

        return client.findByOrgaoId(orgao);

    }

    public Iterable<LicitacaoForm> getContentByNumeroProcesso(String numeroProcesso) {
        // TODO Auto-generated method stub
        return client.getContentByNumeroProcesso(numeroProcesso);

    }

    @Override
    public void processarLicitacao(LicitacaoVO licitacaoVO) {

        Origem origem = oriRP.findByDescricao(licitacaoVO.getOrigem().getDescricao());

        Licitacao licitacao = licitacaoRepo.findByOrigemAndCodigoOrigem(origem, licitacaoVO.getCodigoOrigem());
        if (licitacao == null) {
            licitacao = new Licitacao();
            licitacao.setOrigem(origem);
        }

        try {
            if (licitacaoVO.getArea().getDescricao() != null && !"".equals(licitacaoVO.getArea().getDescricao())) {

                StatusEnum statusEn = StatusEnum.getByDescricao(licitacaoVO.getStatus().getDescricao());
                Status status = statusRP.findOne(statusEn.getCodigo());
                licitacao.setStatus(status);

                if (licitacaoVO.getSecretaria() != null && licitacaoVO.getSecretaria().getDescricao() != null
                        && !"".equals(licitacaoVO.getSecretaria().getDescricao())) {

                    log.debug(licitacaoVO.getSecretaria().getDescricao());
                    pat = Pattern.compile(".*\\s-\\s(\\w.*)");

                    Matcher matSecretaria = pat.matcher(licitacaoVO.getSecretaria().getDescricao());
                    if (matSecretaria.matches()) {
                        String descricaoSecretaria = matSecretaria.group(1);
                        Secretaria secretaria = secretariaRP.findByDescricaoEOrigem(origem.getId(), descricaoSecretaria);
                        licitacao.setSecretaria(secretaria);
                        if (licitacaoVO.getDepartamento() != null && !"".equals(licitacaoVO.getDepartamento().getDescricao())
                                && secretaria != null) {
                            Matcher matDepartamento = pat.matcher(licitacaoVO.getDepartamento().getDescricao());
                            if (matDepartamento.matches()) {
                                String descricaoDepartamento = matDepartamento.group(1);
                                List<Departamento> departamentos = departamentoRP.findBySecretariaEDepartamentoDescricao(
                                        secretaria.getId(),
                                        descricaoDepartamento);

                                Departamento departamento;
                                if (departamentos != null && departamentos.size() > 0) {
                                    departamento = departamentos.get(0);
                                } else {
                                    departamento = new Departamento();
                                    departamento.setDescricao(descricaoDepartamento);
                                    departamento.setSecretaria(secretaria);

                                    departamento = departamentoRP.save(departamento);
                                }
                                licitacao.setDepartamento(departamento);

                            }
                        }
                    }
                }

                AreaOrigem areaOrigem = areaOrigemRP.findByDescricaoEOrigem(licitacaoVO.getArea().getDescricao(), origem.getId());
                if (areaOrigem == null && licitacaoVO.getArea().getDescricao() != null) {
                    areaOrigem = new AreaOrigem();
                    // areaOrigem.setCodigoOrigem(licitacaoVO.getArea().getCodigoOrigem());
                    areaOrigem.setDescricao(licitacaoVO.getArea().getDescricao());
                    areaOrigem.setOrigem(origem);

                    List<Area> areas = areaRP.findByDescricao(licitacaoVO.getArea().getDescricao());
                    Area areaEntity = null;
                    if (areas != null && areas.size() > 0) {
                        areaEntity = areas.get(0);
                    } else {
                        areaEntity = new Area();
                        areaEntity.setDescricao(licitacaoVO.getArea().getDescricao());
                        areaEntity = areaRP.save(areaEntity);
                    }
                    areaOrigem.setArea(areaEntity);
                    areaOrigem = areaOrigemRP.save(areaOrigem);
                } else {
                    licitacao.setArea(areaOrigem.getArea());
                }

                SubArea subArea = null;
                if (licitacao.getArea() != null) {
                    if (licitacaoVO.getSubArea() != null && licitacaoVO.getSubArea().getDescricao() != null) {
                        List<SubAreaOrigem> subAreasOrigem = subAreaOrigemRP.findByDescricaoEOrigem(
                                licitacaoVO.getSubArea().getDescricao(),
                                origem.getId());
                        SubAreaOrigem subAreaOrigem;
                        if (subAreasOrigem == null) {
                            subAreaOrigem = new SubAreaOrigem();
                            // subAreaOrigem.setCodigoOrigem(licitacaoVO.getSubArea().getCodigoOrigem());
                            subAreaOrigem.setDescricao(licitacaoVO.getSubArea().getDescricao());
                            subAreaOrigem.setOrigem(origem);
                            subArea = subRP.findByAreaESubAreaDescricao(licitacao.getArea().getId(), subAreaOrigem.getDescricao());
                            if (subArea == null) {
                                subArea = new SubArea();
                                subArea.setDescricao(licitacaoVO.getSubArea().getDescricao());
                                subArea = subRP.save(subArea);
                            }
                            subAreaOrigem.setSubArea(subArea);
                            subAreaOrigem = subAreaOrigemRP.save(subAreaOrigem);
                        } else {
                            subAreaOrigem = subAreasOrigem.get(0);
                        }
                        licitacao.getArea().setSubAreas(new LinkedList<SubArea>());
                        licitacao.getArea().getSubAreas().add(subAreaOrigem.getSubArea());
                        licitacao.setSubArea(subAreaOrigem.getSubArea());
                    }
                }

                String descricao = licitacaoVO.getOrgao().getDescricao();
                Orgao orgao = orgaoRP.findByOrigemIdAndNomeFantasia(origem.getId(), descricao);
                if (orgao == null && descricao != null) {
                    orgao = new Orgao();
                    orgao.setNomeFantasia(descricao);
                    orgao.setOrigem(origem);
                    orgao = orgaoRP.save(orgao);
                }
                licitacao.setOrgao(orgao);

                Modalidade mod = null;
                if (licitacaoVO.getModalidade().getDescricao() != null) {
                    ModalidadeOrigem modalidadeOR = modalidadeOrigemRepository.findByDescricaoEOrigemId(licitacaoVO.getModalidade()
                            .getDescricao(), origem.getId());
                    if (modalidadeOR != null) {
                        mod = modalidadeOR.getModalidade();
                    } else {
                        modalidadeOR = new ModalidadeOrigem();
                        // modalidadeOR.setCodigoOrigem(licitacaoVO.getModalidade().getCodigoOrigem());
                        modalidadeOR.setDescricao(licitacaoVO.getModalidade().getDescricao());
                        modalidadeOR.setOrigem(origem);
                        mod = modalidadeRP.findByDescricao(licitacaoVO.getModalidade().getDescricao());
                        if (mod == null) {
                            mod = new Modalidade();
                            mod.setAtaRegistroPreco(false);
                            mod.setDescricao(licitacaoVO.getModalidade().getDescricao());
                            mod = modalidadeRP.save(mod);
                        }
                        modalidadeOR.setModalidade(mod);
                        modalidadeOR = modalidadeOrigemRepository.save(modalidadeOR);
                    }
                    licitacao.setModalidade(mod);
                }
                if (licitacaoVO.getDataAbertura() != null)
                    licitacao.setDataAbertura(new Timestamp(licitacaoVO.getDataAbertura().getTime()));

                if (licitacaoVO.getDataPublicacao() != null)
                    licitacao.setDataPublicacao(new java.sql.Date(licitacaoVO.getDataPublicacao().getTime()));

                if (licitacaoVO.getDataEntregaEdital() != null)
                    licitacao.setDataEntregaEdital(new Timestamp(licitacaoVO.getDataEntregaEdital().getTime()));

                if (licitacaoVO.getDataLicitacao() != null)
                    licitacao.setDataLicitacao(new java.sql.Date(licitacaoVO.getDataLicitacao().getTime()));

                if (licitacaoVO.getDataRecebimentoProposta() != null)
                    licitacao.setDataRecebimentoProposta(new Timestamp(licitacaoVO.getDataRecebimentoProposta().getTime()));

                // licitacao.setDataLicitacao(Timestamp.valueOf(LocalDateTime.now())); // Verificar
                licitacao.setNumero(licitacaoVO.getNumero());
                licitacao.setProcesso(licitacaoVO.getProcesso());
                licitacao.setCodigoOrigem(licitacaoVO.getCodigoOrigem());

                licitacao = licitacaoRepo.save(licitacao);

                LocalExecucao le = localExecucaoRP.findByDescricao(licitacaoVO.getLocalExecucao().getDescricao());
                if (le == null) {
                    le = new LocalExecucao();
                    le.setDescricao(licitacaoVO.getLocalExecucao().getDescricao());
                    le = localExecucaoRP.save(le);
                }
                licitacao.setLocalExecucao(le);

                List<Evento> eventosEntity = new LinkedList<Evento>();
                List<EventoVO> eventos = licitacaoVO.getEventos();
                for (Iterator iterator = eventos.iterator(); iterator.hasNext();) {
                    EventoVO eventoVO = (EventoVO) iterator.next();
                    Evento eventoEntity = new Evento();
                    eventoEntity.setCodigoOrigem(eventoVO.getCodigoOrigem());
                    eventoEntity.setIdLicitacao(licitacao.getId());

                    if (eventoVO.getData() != null)
                        eventoEntity.setData(new java.sql.Date(eventoVO.getData().getTime()));

                    if (eventoVO.getDataAberturaSessao() != null)
                        eventoEntity.setDataAberturaSessao(new Timestamp(eventoVO.getDataAberturaSessao().getTime()));

                    if (eventoVO.getDataPublicacao() != null)
                        eventoEntity.setDataPublicacao(new java.sql.Date(eventoVO.getDataPublicacao().getTime()));

                    if (eventoVO.getTipoEvento() != null) {
                        TipoEvento tipoEventoEntity = tipoEventoRP.findByDescricao(eventoVO.getTipoEvento().getDescricao());
                        if (tipoEventoEntity == null) {
                            tipoEventoEntity = new TipoEvento();
                            tipoEventoEntity.setDescricao(eventoVO.getTipoEvento().getDescricao());
                            tipoEventoEntity = tipoEventoRP.save(tipoEventoEntity);
                        }
                        eventoEntity.setTipoEvento(tipoEventoEntity);
                    }
                    eventoEntity = eventoRP.save(eventoEntity);
                    eventoEntity.setSinteseLicitacao(eventoVO.getSinteseLicitacao());
                    eventosEntity.add(eventoEntity);
                }
                licitacao.setEventos(eventosEntity);
                List<Objeto> objetos = new LinkedList<Objeto>();
                for (Iterator iterator = licitacaoVO.getObjetos().iterator(); iterator.hasNext();) {
                    ObjetoVO objetoVO = (ObjetoVO) iterator.next();
                    Objeto objEntity = new Objeto();
                    objEntity.setDescricao(objetoVO.getDescricao());
                    objetos.add(objEntity);
                }
                licitacao.setObjetos(objetos);
                licitacao.setTitulo(licitacaoVO.getTitulo());
                if (licitacaoVO.getTipoLicitacao() != null) {
                    TipoLicitacao tpLicita = tipoLicitacaoRP.findByDescricao(licitacaoVO.getTipoLicitacao().getDescricao());
                    if (tpLicita == null) {
                        tpLicita.setDescricao(licitacaoVO.getTipoLicitacao().getDescricao());
                        tpLicita = tipoLicitacaoRP.save(tpLicita);
                    }
                    licitacao.setTipoLicitacao(tpLicita);
                }

                licitacaoRepo.save(licitacao);
                infraXml.generateXML(licitacao);
                serverSolr.addDocument(licitacao);
            }

        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
    }

    @Override
    public Iterable<LicitacaoForm> getContentByParams(String area, String subArea, String secretaria, String departamento, String orgao,
            String localidade, String modalidade, String status, String numero, String texto) {
        // TODO Auto-generated method stub
        return client.getContentByParams(area, subArea, secretaria, departamento, orgao, localidade, modalidade, status, numero, texto);
    }

}
