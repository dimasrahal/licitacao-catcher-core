package br.com.aset.licitacao.catcher.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aset.licitacao.catcher.adapter.entity.Area;
import br.com.aset.licitacao.catcher.adapter.entity.Departamento;
import br.com.aset.licitacao.catcher.adapter.entity.LocalExecucao;
import br.com.aset.licitacao.catcher.adapter.entity.Modalidade;
import br.com.aset.licitacao.catcher.adapter.entity.Orgao;
import br.com.aset.licitacao.catcher.adapter.entity.Secretaria;
import br.com.aset.licitacao.catcher.adapter.entity.Status;
import br.com.aset.licitacao.catcher.adapter.entity.SubArea;
import br.com.aset.licitacao.catcher.adapter.form.LicitacaoForm;
import br.com.aset.licitacao.catcher.adapter.repository.AreaRepository;
import br.com.aset.licitacao.catcher.adapter.repository.DepartamentoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.LocalExecucaoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.ModalidadeRepository;
import br.com.aset.licitacao.catcher.adapter.repository.OrgaoRepository;
import br.com.aset.licitacao.catcher.adapter.repository.SecretariaRepository;
import br.com.aset.licitacao.catcher.adapter.repository.StatusRepository;
import br.com.aset.licitacao.catcher.adapter.repository.SubAreaRepository;
import br.com.aset.licitacao.catcher.adapter.services.LicitacaoService;

import com.google.common.collect.Iterables;

@Controller
public class ContentController {

    private LicitacaoService contentService;

    LicitacaoForm form = new LicitacaoForm();

    @Autowired
    AreaRepository areaRP;

    @Autowired
    SubAreaRepository subAreaRP;

    @Autowired
    OrgaoRepository orgaoRP;

    @Autowired
    ModalidadeRepository modalidadeRP;

    @Autowired
    SecretariaRepository secretariaRP;

    @Autowired
    DepartamentoRepository departamentoRP;

    @Autowired
    LocalExecucaoRepository localExecucaoRP;

    @Autowired
    StatusRepository status;

    String orgao = "";

    String numeroProcesso = "";

    String orgao_nomeFantasia = "";

    String modalidade_descricao = "";

    String numero = "";

    String texto;

    String idArea;

    public LicitacaoService getContentService() {
        return contentService;
    }

    @Autowired
    public void setContentService(LicitacaoService contentService) {
        this.contentService = contentService;
    }

    @ModelAttribute("areas")
    public List<Area> populateTypes() {

        return Arrays.asList(Iterables.toArray(areaRP.findAll(), Area.class));

    }

    @ModelAttribute("subAreas")
    public List<SubArea> populateSubAreas() {
        List<SubArea> listaRetorno = null;
        if (form.getArea() != null) {
            if (form.getArea().getSubAreas() != null) {
                listaRetorno = form.getArea().getSubAreas();
            } else {
                listaRetorno = subAreaRP.findByAreaId(form.getArea().getId());
            }

        }
        if (listaRetorno == null) {
            listaRetorno = new LinkedList<SubArea>();
        }
        return listaRetorno;

    }

    @ModelAttribute("orgaos")
    public List<Orgao> populateOrgaos() {

        return Arrays.asList(Iterables.toArray(orgaoRP.findAll(), Orgao.class));

    }

    @ModelAttribute("modalidades")
    public List<Modalidade> populateModalidades() {

        return Arrays.asList(Iterables.toArray(modalidadeRP.findAll(), Modalidade.class));

    }

    @ModelAttribute("secretarias")
    public List<Secretaria> populateSecretarias() {

        return Arrays.asList(Iterables.toArray(secretariaRP.findAll(), Secretaria.class));

    }

    @ModelAttribute("departamentos")
    public List<Departamento> populateDepartamentos() {

        return Arrays.asList(Iterables.toArray(departamentoRP.findAll(), Departamento.class));

    }

    @ModelAttribute("localidades")
    public List<LocalExecucao> populateLocalidades() {

        return Arrays.asList(Iterables.toArray(localExecucaoRP.findAll(), LocalExecucao.class));

    }

    @ModelAttribute("listaStatus")
    public List<Status> populateStatus() {

        return Arrays.asList(Iterables.toArray(status.findAll(), Status.class));

    }

    @RequestMapping(value = "/contents", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contents", contentService.listAllContents());
        System.out.println("Quantidade encontrada:");
        return "contents";
    }

    @RequestMapping("content/find")
    public String findContentByParams(@RequestParam String area, @RequestParam String subArea, @RequestParam String secretaria,
            @RequestParam String departamento, @RequestParam String orgao, @RequestParam String localidade,
            @RequestParam String modalidade, @RequestParam String status, @RequestParam String numero, @RequestParam String sintese
            , Model model) {

        if (area != null && !"".equals(area) && Integer.parseInt(area) == 0) {
            area = "";
        }
        if (subArea != null && !"".equals(subArea) && Integer.parseInt(subArea) == 0) {
            subArea = "";
        }
        if (secretaria != null && !"".equals(secretaria) && Integer.parseInt(secretaria) == 0) {
            secretaria = "";
        }
        if (departamento != null && !"".equals(departamento) && Integer.parseInt(departamento) == 0) {
            departamento = "";
        }
        if (orgao != null && !"".equals(orgao) && Integer.parseInt(orgao) == 0) {
            orgao = "";
        }
        if (localidade != null && !"".equals(localidade) && Integer.parseInt(localidade) == 0) {
            localidade = "";
        }
        if (modalidade != null && !"".equals(modalidade) && Integer.parseInt(modalidade) == 0) {
            modalidade = "";
        }

        model.addAttribute(
                "contents",
                contentService.getContentByParams(area, subArea, secretaria, departamento, orgao, localidade,
                        modalidade, status, numero, sintese));

        return "contents";
    }

    @RequestMapping("content/{id}")
    public String showContent(@PathVariable String id, Model model) {
        model.addAttribute("content", contentService.getLicitacaoById(Integer.parseInt(id)));
        return "contentshow";
    }

    @RequestMapping("content/inicioBusca")
    public String newProduct(Model model) {
        model.addAttribute("content", form);
        return "contentform";
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getOrgao_nomeFantasia() {
        return orgao_nomeFantasia;
    }

    public void setOrgao_nomeFantasia(String orgao_nomeFantasia) {
        this.orgao_nomeFantasia = orgao_nomeFantasia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getModalidade_descricao() {
        return modalidade_descricao;
    }

    public void setModalidade_descricao(String modalidade_descricao) {
        this.modalidade_descricao = modalidade_descricao;
    }

    public LicitacaoForm getForm() {
        return form;
    }

    public void setForm(LicitacaoForm form) {
        this.form = form;
    }

    /*
     * @RequestMapping("product/edit/{id}")
     * public String edit(@PathVariable Integer id, Model model){
     * model.addAttribute("product", productService.getProductById(id));
     * return "productform";
     * }
     * 
     * @RequestMapping("product/new")
     * public String newProduct(Model model){
     * model.addAttribute("product", new Product());
     * return "productform";
     * }
     * 
     * @RequestMapping(value = "product", method = RequestMethod.POST)
     * public String saveProduct(Product product){
     * 
     * productService.saveProduct(product);
     * 
     * return "redirect:/product/" + product.getId();
     * }
     */

}
