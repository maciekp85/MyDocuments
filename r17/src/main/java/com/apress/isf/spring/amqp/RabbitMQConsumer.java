package com.apress.isf.spring.amqp;

import com.apress.isf.java.model.Document;

/**
 * Created by nishi on 2016-04-19.
 */
public interface RabbitMQConsumer {
    public void process(Document document);
}
