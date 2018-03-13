package br.com.aset.licitacao.catcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.jms.annotation.EnableJms;

/*
 * @EnableAutoConfiguration(exclude = {JndiConnectionFactoryAutoConfiguration.class,DataSourceAutoConfiguration.class,
 * HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration
 * .class})
 * 
 * @EnableJpaRepositories(basePackages = {"br.com.dw3.conteudo.poc.catcher.adapter.repositories"})
 * 
 * @ComponentScan
 */

@Configuration
@ComponentScan
@EnableJms
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
    /*
     * @Bean
     * public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
     * DefaultJmsListenerContainerFactoryConfigurer configurer) {
     * DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
     * // This provides all boot's default to this factory, including the message converter
     * configurer.configure(factory, connectionFactory);
     * // You could still override some of Boot's default if necessary.
     * return factory;
     * }
     */

}