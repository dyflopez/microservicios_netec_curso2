package com.ms.user.producer;

import com.ms.user.dto.JmsEmailDetails;

public interface IEmailProducer {

    void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails);
}
