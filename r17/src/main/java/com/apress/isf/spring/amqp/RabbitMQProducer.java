package com.apress.isf.spring.amqp;

import com.apress.isf.java.model.Document;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nishi on 2016-04-19.
 */
@Component("rabbitmqProducer")
public class RabbitMQProducer {
    private static final String EXCHANGE = "mydocuments";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Document document) {
        rabbitTemplate.convertAndSend(EXCHANGE, document.getType().getExtension(), document);
    }
}
