package com.sonny.ctcompte;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQService {

    private RabbitTemplate template;

    public void publier(Compte compte) {
        this.template.convertAndSend(compte);
    }
}
