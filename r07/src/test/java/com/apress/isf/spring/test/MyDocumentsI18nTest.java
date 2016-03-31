package com.apress.isf.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

import static java.lang.System.out;

/**
 * Created by nishi on 2016-03-31.
 */
public class MyDocumentsI18nTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsI18nTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-i18n-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Do przetłumaczenia...");
        String polish = context.getMessage("main.title", null, new Locale("pl"));
        String spanish = context.getMessage("main.title", null, new Locale("es"));
        out.println("Polish: " + polish);
        out.println("Spanish: " + spanish);
    }
}
