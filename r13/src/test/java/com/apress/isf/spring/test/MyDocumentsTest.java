package com.apress.isf.spring.test;

import com.apress.isf.spring.email.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/mydocuments-context.xml")
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    EmailService email;

    @Test
    public void testScheduler() throws InterruptedException {
        Thread.sleep(45000);
    }

    @Ignore
    @Test
    public void testAsyncEmail() throws InterruptedException {
        log.debug("Testowanie asynchronicznych wiadomości...");
        assertNotNull(email);
        long start = new Date().getTime();
        email.sendAsync("maciejpiotrowski85@hotmail.com", "maciejpiotrowski85@hotmail.com", "Dodanie nowego dokumentu 2", "Dodano nowy dokument 2 do kolekcji");
        long end = new Date().getTime();
        long time = (end - start);
        log.debug("Wysłano asynchronicznie wiadomość e-mail. Zajęło to: " + time + " sekund.");
    }

    @Ignore
    @Test
    public void testEmail() throws InterruptedException {
        log.debug("Testowanie poczty e-mail...");
        assertNotNull(email);

        long start = new Date().getTime();
        email.send("maciejpiotrowski85@hotmail.com", "maciejpiotrowski85@hotmail.com", "Dodanie nowego dokumentu", "Dodano nowy dokument do kolekcji");
        long end = new Date().getTime();
        long time = (end - start);
        log.debug("Wysłano wiadomość e-mail. Zajęło to: " + time + " sekund.");
    }
}
