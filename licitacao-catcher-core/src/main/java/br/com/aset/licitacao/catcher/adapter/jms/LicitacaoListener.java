package br.com.aset.licitacao.catcher.adapter.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import br.com.aset.licitacao.catcher.adapter.core.vo.LicitacaoVO;
import br.com.aset.licitacao.catcher.adapter.services.LicitacaoService;

@Service
public class LicitacaoListener {

    private static final Logger log = LoggerFactory.getLogger(LicitacaoListener.class);

    @Autowired
    LicitacaoService service;

    @Value("${aws.sqs.queue.inbound.name}")
    private String inboundQueueName;

    @JmsListener(destination = "${aws.sqs.queue.inbound.name}")
    public void receberMensagem(String mensagem) throws Exception {

        log.info("Mensagem {} recebida da fila {}, enviando para processamento");

        LicitacaoVO licitacao = toLicitacaoVO(mensagem);
        if (licitacao != null)
            service.processarLicitacao(licitacao);
    }

    private LicitacaoVO toLicitacaoVO(String mensagem) {
        LicitacaoVO licitacao = null;
        try {
            licitacao = LicitacaoVO.deserialize(mensagem);
        } catch (Exception e) {
            log.error("Problema ao fazer o cast da mensagem " + mensagem);
            System.err.println("Problema ao fazer o cast da mensagem " + mensagem);
        }
        return licitacao;
    }

}
