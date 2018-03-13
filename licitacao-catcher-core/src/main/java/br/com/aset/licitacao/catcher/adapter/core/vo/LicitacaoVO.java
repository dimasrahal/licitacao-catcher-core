package br.com.aset.licitacao.catcher.adapter.core.vo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class LicitacaoVO {

    private static final Logger log = LoggerFactory.getLogger(LicitacaoVO.class);

    private static final String ERRO_JSON = "Erro ParseObject JSON:";

    private int id;

    private String codigoOrigem;

    private String numero;

    private String processo;

    private String titulo;

    private String ofertaCompra;

    private String notaReserva;

    private boolean isRegistroPreco;

    private StatusVO status;

    private OrgaoVO orgao;

    private TipoLicitacaoVO tipoLicitacao;

    private SecretariaVO secretaria;

    private DepartamentoVO departamento;

    private AreaVO area;

    private SubAreaVO subArea;

    private OrigemVO origem;

    private ModalidadeVO modalidade;

    private LocalidadeVO localidade;

    private LocalExecucaoVO localExecucao;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataLicitacao;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataPublicacao;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataAbertura;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataEntregaEdital;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataRecebimentoProposta;

    private List<ObjetoVO> objetos;

    private List<EventoVO> eventos;

    private String texto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public OrgaoVO getOrgao() {
        return orgao;
    }

    public void setOrgao(OrgaoVO orgao) {
        this.orgao = orgao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public DepartamentoVO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoVO departamento) {
        this.departamento = departamento;
    }

    public AreaVO getArea() {
        return area;
    }

    public void setArea(AreaVO area) {
        this.area = area;
    }

    public SubAreaVO getSubArea() {
        return subArea;
    }

    public void setSubArea(SubAreaVO subArea) {
        this.subArea = subArea;
    }

    public ModalidadeVO getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeVO modalidade) {
        this.modalidade = modalidade;
    }

    public LocalidadeVO getLocalidade() {
        return localidade;
    }

    public List<ObjetoVO> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoVO> objetos) {
        this.objetos = objetos;
    }

    public List<EventoVO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoVO> eventos) {
        this.eventos = eventos;
    }

    public String getOfertaCompra() {
        return ofertaCompra;
    }

    public void setOfertaCompra(String ofertaCompra) {
        this.ofertaCompra = ofertaCompra;
    }

    public String getNotaReserva() {
        return notaReserva;
    }

    public void setNotaReserva(String notaReserva) {
        this.notaReserva = notaReserva;
    }

    public boolean isRegistroPreco() {
        return isRegistroPreco;
    }

    public void setRegistroPreco(boolean isRegistroPreco) {
        this.isRegistroPreco = isRegistroPreco;
    }

    public SecretariaVO getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaVO secretaria) {
        this.secretaria = secretaria;
    }

    public OrigemVO getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemVO origem) {
        this.origem = origem;
    }

    public LocalExecucaoVO getLocalExecucao() {
        return localExecucao;
    }

    public void setLocalExecucao(LocalExecucaoVO localExecucao) {
        this.localExecucao = localExecucao;
    }

    public void setLocalidade(LocalidadeVO localidade) {
        this.localidade = localidade;
    }

    public TipoLicitacaoVO getTipoLicitacao() {
        return tipoLicitacao;
    }

    public void setTipoLicitacao(TipoLicitacaoVO tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }

    public Date getDataEntregaEdital() {
        return dataEntregaEdital;
    }

    public void setDataEntregaEdital(Date dataEntregaEdital) {
        this.dataEntregaEdital = dataEntregaEdital;
    }

    public Date getDataRecebimentoProposta() {
        return dataRecebimentoProposta;
    }

    public void setDataRecebimentoProposta(Date dataRecebimentoProposta) {
        this.dataRecebimentoProposta = dataRecebimentoProposta;
    }

    public Date getDataLicitacao() {
        return dataLicitacao;
    }

    public void setDataLicitacao(Date dataLicitacao) {
        this.dataLicitacao = dataLicitacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public StatusVO getStatus() {
        return status;
    }

    public void setStatus(StatusVO status) {
        this.status = status;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_EMPTY);

        String jsonInString = null;

        try {
            jsonInString = mapper.writeValueAsString(this);
        } catch (JsonGenerationException e) {
            log.error(ERRO_JSON + e.getMessage());
        } catch (JsonMappingException ex) {
            log.error(ERRO_JSON + ex.getMessage());
        } catch (IOException ez) {
            log.error(ERRO_JSON + ez.getMessage());
        }

        return jsonInString;
    }

    public static LicitacaoVO deserialize(String message) {
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(df);

        LicitacaoVO dto = null;
        try {
            dto = (LicitacaoVO) mapper.readValue(message, LicitacaoVO.class);
        } catch (JsonGenerationException e) {
            log.error(ERRO_JSON + e);
        } catch (JsonMappingException ex) {
            log.error(ERRO_JSON + ex);
        } catch (IOException ez) {
            log.error(ERRO_JSON + ez);
        }

        return dto;
    }

}
