package br.com.aset.licitacao.catcher.adapter.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.aset.licitacao.catcher.infra.file.DateAdapter;
import br.com.aset.licitacao.catcher.infra.file.TimestampAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQueries({
        @NamedQuery(name = "Licitacao.findByOrigemAndCodigoOrigem", query = "SELECT a FROM Licitacao a WHERE a.origem = ?1 and LOWER(a.codigoOrigem) = LOWER(?2) ")

})
@Table(name = "licitacao")
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String numero;

    private String processo;

    private String titulo;

    private String ofertaCompra;

    private String notaReserva;

    private boolean isRegistroPreco;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_orgao")
    private Orgao orgao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_tipo_licitacao")
    private TipoLicitacao tipoLicitacao;

    @ManyToOne
    @JoinColumn(name = "id_secretaria")
    private Secretaria secretaria;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "id_subarea")
    private SubArea subArea;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    @ManyToOne
    @JoinColumn(name = "id_modalidade")
    private Modalidade modalidade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_local_execucao")
    private LocalExecucao localExecucao;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dataLicitacao;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dataPublicacao;

    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp dataAbertura;

    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp dataEntregaEdital;

    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp dataRecebimentoProposta;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_licitacao")
    private List<Objeto> objetos;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_licitacao")
    private List<Evento> eventos;

    @Transient
    private String texto;

    private String codigoOrigem;

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

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
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

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public LocalExecucao getLocalExecucao() {
        return localExecucao;
    }

    public void setLocalExecucao(LocalExecucao localExecucao) {
        this.localExecucao = localExecucao;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public TipoLicitacao getTipoLicitacao() {
        return tipoLicitacao;
    }

    public void setTipoLicitacao(TipoLicitacao tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }

    public Timestamp getDataEntregaEdital() {
        return dataEntregaEdital;
    }

    public void setDataEntregaEdital(Timestamp dataEntregaEdital) {
        this.dataEntregaEdital = dataEntregaEdital;
    }

    public Timestamp getDataRecebimentoProposta() {
        return dataRecebimentoProposta;
    }

    public void setDataRecebimentoProposta(Timestamp dataRecebimentoProposta) {
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

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

}
