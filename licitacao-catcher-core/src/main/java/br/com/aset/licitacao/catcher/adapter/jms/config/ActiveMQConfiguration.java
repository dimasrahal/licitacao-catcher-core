package br.com.aset.licitacao.catcher.adapter.jms.config;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfiguration {

    private String user = env("ACTIVEMQ_USER", "aset");

    private String password = env("ACTIVEMQ_PASSWORD", "123456");

    private String host = env("ACTIVEMQ_HOST", "localhost");

    private int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));

    JmsConnectionFactory factory;

    public Session getSession() {
        Session session = null;
        Connection connection;
        try {
            connection = getFactory().createConnection(user, password);
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return session;

    }

    public JmsConnectionFactory getFactory() {
        String connectionURI = "amqp://" + host + ":" + port;

        if (factory == null)
            factory = new JmsConnectionFactory(connectionURI);

        return factory;
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if (rc == null)
            return defaultValue;
        return rc;
    }
}
