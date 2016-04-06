package com.apress.isf.spring.amqp;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.utils.XmlUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nishi on 2016-04-05.
 */
@Component("rabbitmqProducer")
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Document document) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/xml");
        byte[] body = XmlUtils.toXml(document).getBytes();
        Message message = new Message(body, messageProperties);
        rabbitTemplate.send(message);
    }
}
