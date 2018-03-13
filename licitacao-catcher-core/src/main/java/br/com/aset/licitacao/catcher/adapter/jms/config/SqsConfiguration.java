package br.com.aset.licitacao.catcher.adapter.jms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import br.com.fast.aws.connection.sqs.SqsAdapterConfiguration;

@Configuration
@EnableJms
public class SqsConfiguration {

    @Value("${aws.access.key}")
    private String awsAccessKey;

    @Value("${aws.secret.key}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.sqs.endpoint.use}")
    private boolean sqsUseEndpoint;

    @Value("${aws.sqs.endpoint.host}")
    private String sqsHost;

    @Value("${aws.sqs.endpoint.port}")
    private Integer sqsPort;

    @Value("${aws.sqs.queue.inbound.name}")
    private String sqsInboundQueue;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        return new SqsAdapterConfiguration()
                .withAwsAccessKey(awsAccessKey)
                .withAwsSecretKey(awsSecretKey)
                .withAwsRegion(awsRegion)
                .withUseEndpoint(sqsUseEndpoint)
                .withHost(sqsHost)
                .withPort(sqsPort)
                .withSqsInboundQueue(sqsInboundQueue)
                .withConcurrency("1")
                .withSQSListener();
    }
}