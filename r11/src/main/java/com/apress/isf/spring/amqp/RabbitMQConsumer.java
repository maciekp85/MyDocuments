package com.apress.isf.spring.amqp;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by nishi on 2016-04-06.
 */
@Component("rabbitmqConsumer")
public class RabbitMQConsumer implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Override
    public void onMessage(Message message) {
        Document document = XmlUtils.fromXML(new String(message.getBody()), Document.class);
        log.debug("Dokument odebrany: " + document);
    }
}
