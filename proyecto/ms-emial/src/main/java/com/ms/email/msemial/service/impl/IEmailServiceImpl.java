package com.ms.email.msemial.service.impl;

import com.ms.email.msemial.dto.jms.JmsEmailDetails;
import com.ms.email.msemial.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class IEmailServiceImpl implements IEmailService {

    @Value("${spring.mail.username}") private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(JmsEmailDetails details) {

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getBody());
            mailMessage.setSubject(details.getEmailType());


            javaMailSender.send(mailMessage);
        }

        catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }

}
