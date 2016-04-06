package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.amqp.RabbitMQProducer;
import com.apress.isf.spring.jms.JMSProducer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    //na podstawie pliku META-INF/data/jms.txt - tylko jeden rekord
    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;
    private static final String DOCUMENT_ID = "df569fa4-a513-4252-9810-818cade184ca";

    @Autowired
    private SearchEngine engine;
    @Autowired
    private JMSProducer jmsProducer;

    @Test
    public void testSpringJMS_1() {
        log.debug("Testowanie producenta Spring JMS...");
        jmsProducer.send();
    }

    @Test
    public void testSpringJMS_2() throws InterruptedException {
        log.debug("Testowanie nasłuchiwania i wstawiania...");
        assertNotNull(engine);

        //Czeka przynajmniej 5 sekund na skonsumowanie wiadomości
        Thread.sleep(5000);
        //Po wiadomości JMS i wstawieniu musi być 5 dokumentów
        assertEquals(MAX_ALL_DOCS, engine.listAll().size());

        Type documentType = new Type("WEB", ".url");
        assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
    }

    @Autowired
    RabbitMQProducer rabbitmqProducer;

    @Test
    public void testSpringRabbitMQ_1() {
        log.debug("Testowanie producenta RabbitMQ...");
        assertNotNull(rabbitmqProducer);

        Document document = engine.findById(DOCUMENT_ID);
        assertNotNull(document);
        rabbitmqProducer.send(document);
    }
}
