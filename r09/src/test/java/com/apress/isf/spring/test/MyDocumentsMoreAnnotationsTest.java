package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-03-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsMoreAnnotationsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsMoreAnnotationsTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @Timed(millis = 200)
    @Test
    public void testUsingSpringTimedAnnotationTest() throws InterruptedException {
        log.debug("Użycie narzędzi Spring Test:");

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        Thread.sleep(500);

        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

    @Repeat(10)
    @Test
    public void testUsingSpringRepeatedAnnotationTest() {
        log.debug("Ten napis powinien zostać wydrukowany 10 razy");
    }
}
