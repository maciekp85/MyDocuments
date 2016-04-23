package com.apress.isf.spring.amqp;

import com.apress.isf.java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by nishi on 2016-04-19.
 */
@Component("pdfConsumer")
public class PdfDocumentConsumer implements RabbitMQConsumer {
    private static final Logger log = LoggerFactory.getLogger(PdfDocumentConsumer.class);

    @Override
    public void process(Document document) {
        log.debug("Odebrano dokument PDF: " + document);
    }
}
