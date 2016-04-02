package com.apress.isf.spring.test;

import com.apress.isf.spring.views.Menu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-03-30.
 */
public class MyDocumentsWithResourceInjectionTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Wywołanie menu jako wstrzyknięcie zasobu: ");
        Menu menu = new Menu();
        menu = context.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu();
    }
}
