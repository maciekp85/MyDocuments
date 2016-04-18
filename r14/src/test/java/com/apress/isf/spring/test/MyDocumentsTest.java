package com.apress.isf.spring.test;

import com.apress.isf.spring.service.SecurityServiceFacade;
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
@ContextConfiguration("classpath:META-INF/mydocuments-context.xml")
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private static String EMAIL = "john@email.com";
    private static String PASSWORD = "doe";

    @Autowired
    SecurityServiceFacade security;

    @Test
    public void testSecurity() {
        assertNotNull(security);

        assertTrue(security.areCredentialsValid(EMAIL, PASSWORD));
    }


}
