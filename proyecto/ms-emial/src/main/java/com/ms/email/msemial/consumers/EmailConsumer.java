package com.ms.email.msemial.consumers;

import com.ms.email.msemial.configs.MsEmailConfig;
import com.ms.email.msemial.dto.jms.JmsEmailDetails;
import com.ms.email.msemial.service.IEmailService;
import com.ms.email.msemial.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;


@Slf4j
@Component
@ConditionalOnProperty(value = "activemq.jms-listener.enabled", matchIfMissing = true)
public class EmailConsumer {


    private final IEmailService iEmailService;

    private final MsEmailConfig msEmailConfig;


    public EmailConsumer(IEmailService iEmailService, MsEmailConfig msEmailConfig) {
        this.iEmailService = iEmailService;
        this.msEmailConfig = msEmailConfig;
    }


    @JmsListener(destination = "${activemq.msemail.transaction-status-changes.queue}",
            containerFactory = "jmsListenerContainerFactoryLoyalty")
    public void transactionStatusChange(Message<String> message, Session session) throws JMSException {

        JmsEmailDetails details = new JmsEmailDetails();


        try {

            String jsonMessage = message.getPayload();
            details = JsonUtils.jsonToObject(jsonMessage, JmsEmailDetails.class);
            details.setBody(mensajeEmail(details));

            log.trace("ActiveMQ incomming message from {}: \n{}", jsonMessage);

            iEmailService.sendSimpleMail(details);

        } catch (Exception e) {
            log.error("Error proccessing JSON message\n{}", e.getLocalizedMessage());
        }
    }

    private String mensajeEmail(JmsEmailDetails emailDetails) {


        String body;

        if (emailDetails.getEmailType().equalsIgnoreCase(MsEmailConfig.WELCOME)) {
          /*  String welcomeMessage = msEmailConfig.getBodyMessage(MsEmailConfig.WELCOME);
            String nombre = emailDetails.getName();*/
            body = String.format(msEmailConfig.getBodyMessage(MsEmailConfig.WELCOME), emailDetails.getName());
        } else if (emailDetails.getEmailType().equalsIgnoreCase(MsEmailConfig.WITHDRAWAL)) {
            body = msEmailConfig.getBodyMessage(MsEmailConfig.WITHDRAWAL);
        } else if (emailDetails.getEmailType().equalsIgnoreCase(MsEmailConfig.UPDATE)) {
            body = msEmailConfig.getBodyMessage(MsEmailConfig.UPDATE);
        } else if (emailDetails.getEmailType().equalsIgnoreCase(MsEmailConfig.DEPOSIT)) {
            body = msEmailConfig.getBodyMessage(MsEmailConfig.DEPOSIT);
        } else if (emailDetails.getEmailType().equalsIgnoreCase(MsEmailConfig.DELETION)) {
            body = msEmailConfig.getBodyMessage(MsEmailConfig.DELETION);
        } else {
            body = "Thank you for being on our platform.";
        }


        return body;
    }

}
