package com.ms.email.msemial.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "msemail")
public class MsEmailConfig {


    public static final String WELCOME = "welcome";

    public static final String WITHDRAWAL = "withdrawal";

    public static final String UPDATE = "update";

    public static final String DEPOSIT = "deposit";

    public static final String DELETION = "deletion";
    private Map<String, String> message;

    private Map<String, String> body;

    public String getTransactionType(final String typeCode) {
        return message.get(typeCode);
    }

    public String getBodyMessage(final String typeCode) {
        return body.get(typeCode);
    }

}
