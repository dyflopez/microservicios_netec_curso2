package com.ms.user.conf;


import lombok.Data;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Configuration
public class JmsConfig {


    @Bean
    @Primary
    public ActiveMQConnectionFactory connectionFactoryLoyalty() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        return connectionFactory;
    }

    @Bean
    @Primary
    public JmsTemplate jmsTemplateLoyalty() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactoryLoyalty());
        return template;
    }

    @Bean
    @Primary
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactoryLoyalty() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactoryLoyalty());
        factory.setPubSubDomain(false);
        return factory;
    }

}
