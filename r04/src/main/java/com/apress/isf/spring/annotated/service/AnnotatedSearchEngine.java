package com.apress.isf.spring.annotated.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.service.SearchEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {

    private static final Logger log = LoggerFactory.getLogger(AnnotatedSearchEngine.class);

    @Autowired
    private DocumentDAO documentDAO;

    public AnnotatedSearchEngine() {
        if(log.isDebugEnabled())
            log.debug("Utworzone egzemplarz klasy AnnotatedSearchEngine: " + this);
    }

    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document: listAll()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }

        return result;
    }

    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }

}
