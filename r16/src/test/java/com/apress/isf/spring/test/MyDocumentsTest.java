package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.DocumentService;
import com.apress.isf.java.service.TypeService;
import com.apress.isf.spring.amqp.RabbitMQProducer;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.data.TypeDAO;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/mydocuments-context.xml", "classpath:META-INF/spring/mydocuments-mongo-context.xml"})
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @Autowired
    DocumentService documentFacade;

    @Test
    public void testProducer() {
        log.debug("Testowanie producenta RabbitMQ...");
        assertNotNull(rabbitMQProducer);
        assertNotNull(documentFacade);
        for (Document document: documentFacade.getAllDocuments())
            rabbitMQProducer.send(document);
    }

    @Test
    public void testJustWait() throws InterruptedException {
        Thread.sleep(5000);
    }
}
