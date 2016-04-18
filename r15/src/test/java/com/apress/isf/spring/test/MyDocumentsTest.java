package com.apress.isf.spring.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.DocumentService;
import com.apress.isf.java.service.TypeService;
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
@ContextConfiguration("classpath:META-INF/mydocuments-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsTest {
    private static Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private static final String ID = "1acbb68a-a859-49c9-ac88-d9e9322bac55";
    private static final String NAME = "Szablon książki";
    private static final String NAME_UPDATED = "Moja książka";

    @Autowired
    DocumentDAO mongoDocumentDAO;
    @Autowired
    TypeDAO mongoTypeDAO;

    @Autowired
    DocumentService documentFacade;
    @Autowired
    TypeService typeFacade;

    @Autowired
    MongoOperations mongoTemplate;

    @Test
    public void testMongoDBMigration() {
        log.debug("Testowanie Spring Data MongoDB - migracja (uruchamiać tylko raz) ...");
        assertNotNull(mongoDocumentDAO);
        assertNotNull(mongoTypeDAO);
        assertNotNull(documentFacade);
        assertNotNull(typeFacade);

        List<Type> types = typeFacade.getAllDefinedTypes();
        assertNotNull(types);
        assertEquals(4, types.size());

        for(Type type: types) {
            mongoTypeDAO.save(type);
        }

        List<Document> documents = documentFacade.getAllDocuments();
        assertNotNull(documents);
        assertEquals(6, documents.size());

        for(Document document: documents) {
            mongoDocumentDAO.save(document.getDocumentId(), document);
        }
    }

    @Test
    @Ignore
    public void testMongoDBFind() {
        log.debug("Testowanie Spring Data MongoDB ... [FIND]");
        assertNotNull(mongoDocumentDAO);
        Document document = mongoDocumentDAO.findById(ID);
        assertNotNull(document);
        assertEquals(NAME, document.getName());
        log.debug(document.toString());
    }

    @Test
    @Ignore
    public void testMongoDBUpdate() {
        log.debug("Testowanie Spring Data MongoDB ... [UPDATE]");
        assertNotNull(mongoDocumentDAO);
        Document document = new Document(ID, NAME_UPDATED);
        assertNotNull(document);
        Document updatedDocument = mongoDocumentDAO.save(ID, document);
        assertNotNull(updatedDocument);
        log.debug(updatedDocument.toString());
    }

    @Test
    @Ignore
    public void testMongoDBRemove() {
        log.debug("Testowanie Spring Data MongoDB ... [UPDATE]");
        assertNotNull(mongoDocumentDAO);
        Document document = mongoDocumentDAO.removeById(ID);
        assertNull(document);
    }

    @Test
//    @Ignore
    public void testMongoDBRemoveAllDocuments() {
        log.debug("Testowanie Spring Data MongoDB ... [REMOVE_ALL_DOCUMENTS]");
        assertNotNull(mongoTemplate);
        mongoDocumentDAO.removeAll();
    }

    @Test
//    @Ignore
    public void testMongoDBRemoveAllTypes() {
        log.debug("Testowanie Spring Data MongoDB ... [REMOVE_ALL_TYPES]");
        assertNotNull(mongoTemplate);
        mongoTypeDAO.removeAll();
    }
}
