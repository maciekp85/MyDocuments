package com.apress.isf.spring.test;

import com.apress.isf.java.service.Login;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-03-31.
 */
public class MyDocumentsWithLoginTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test123";
    private static final String SUCCESS = "Ten użytkownik ma atoryzację";
    private static final String FAILURE = "UWAGA! Ten użytkownik nie ma autoryzacji!";
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-login-context.xml");
    }

    @Test
    public void testLogin() {
        log.debug("Test logowania");
        Login login = context.getBean(Login.class);
        assertNotNull(login);
        if(login.isAuthorized(EMAIL, PASS))
            out.println(SUCCESS);
        else
            out.println(FAILURE);
    }

}
