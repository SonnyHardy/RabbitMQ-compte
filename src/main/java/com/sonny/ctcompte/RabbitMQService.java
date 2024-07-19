package com.sonny.ctcompte;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQService {

    @Autowired
    private RabbitTemplate template;
    private @Value("${application.exchanges.user.name}") String userExchangeName;
    private @Value("${application.exchanges.user.routing-key}") String userExchangeRoutingKey;
    private @Value("${application.exchanges.notification.name}") String notificationExchangeName;
    private @Value("${application.exchanges.notification.routing-key}") String notificationExchangeRoutingKey;


    public void publier(Compte compte) {
        this.template.convertAndSend(userExchangeName, userExchangeRoutingKey, compte);
        this.template.convertAndSend(notificationExchangeName, notificationExchangeRoutingKey, compte);
    }


}
