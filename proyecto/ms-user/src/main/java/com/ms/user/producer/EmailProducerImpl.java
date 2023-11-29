package com.ms.user.producer;

import com.ms.user.dto.JmsEmailDetails;
import com.ms.user.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class EmailProducerImpl implements  IEmailProducer{

    private  final JmsTemplate template;

    public EmailProducerImpl(JmsTemplate template) {
        this.template = template;
    }

    @Override
    public void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails) {
        try {

            final String mensaje = JsonUtils.convertToJson(jmsEmailDetails);
            template.setPubSubDomain(false);

            template.convertAndSend(
                    "ms.send.email.queue",
                    mensaje
            );

log.info("mensaje enviado");

        }catch (JmsException e){
            log.error(e.getMessage());
        }
    }
}
