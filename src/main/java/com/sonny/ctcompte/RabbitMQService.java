package com.sonny.ctcompte;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitMQService {

    @Autowired
    private RabbitTemplate template;
    private @Value("${application.exchanges.user.name}") String userExchangeName;


    public void publier(Compte compte) {
        this.template.convertAndSend(userExchangeName,
                null,
                compte,
                messageProcessor -> {
            final Map<String, String> headers = Map.of("type", "user", "action", "notification");
            messageProcessor.getMessageProperties().getHeaders().putAll(headers);
            return messageProcessor;
                });

    }


}
