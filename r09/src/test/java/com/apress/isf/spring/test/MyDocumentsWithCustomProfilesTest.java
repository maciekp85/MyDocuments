package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.test.profile.CustomProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-03-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-custom-profiles-context.xml")
@ProfileValueSourceConfiguration(CustomProfile.class)
public class MyDocumentsWithCustomProfilesTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithCustomProfilesTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @IfProfileValue(name = "environment", values = "dev")
    @Test
    public void testUsingSpringTestWithCustomProfilesX() {
        try {
            log.debug("Użycie narzedzi Spring Test:");

            List<Document> documents = engine.findByType(webType);
            assertNotNull(documents);
            assertEquals(webType.getName(), documents.get(0).getType().getName());
            assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
            assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

            documents = engine.listAll();
            assertNotNull(documents);
            assertTrue(documents.size() == 4);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    @IfProfileValue(name = "os.name", value = "Unix")
    @Test
    public void testUsingSpringTestWithCustomProfilesY() {
        try {
            log.debug("Użycie narzędzi Spring Test w systemie Unix:");

            // More testing
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
