package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.spring.service.DocumentServiceFacade;
import com.apress.isf.spring.service.TypeServiceFacade;
import com.apress.isf.spring.social.DocumentTweet;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@ContextConfiguration({"classpath:META-INF/spring/mydocuments-context.xml", "classpath:META-INF/spring/mydocuments-mongo-context.xml"})
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    //The ID was taken from the src/main/resources/META-INF/data/data.sql
    private final String WEB_TYPE_ID = "4980d2e4-a424-4ff4-a0b2-476039682f43";

    @Autowired
    DocumentServiceFacade documentFacade;

//    @Autowired
//    DocumentTweet documentTweet;

    @Autowired
    TypeServiceFacade typeFacade;

//    @Test
//    public void testProducer() {
//        log.debug("Testowanie rozszerzenia Spring Social...");
//        assertNotNull(documentTweet);
//        documentTweet.tweet("Playing with Spring Social");
//    }

    @Test
    public void testMyDocumentsTwitter() {
        log.debug("Testowanie aplikacji Moje Dokumenty i rozszerzenia Spring Social...");
        assertNotNull(documentFacade);
        assertNotNull(typeFacade);
        Document document = new Document();
        document.setName("Beginning Blender");
        document.setType(typeFacade.getTypeById(WEB_TYPE_ID));
        document.setDescription("");
        document.setLocation("http://www.apress.com/9781430262237");

        documentFacade.saveDocument(document.getDocumentId(), document);
    }
}
