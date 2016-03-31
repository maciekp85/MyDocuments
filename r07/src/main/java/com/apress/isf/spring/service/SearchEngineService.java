package com.apress.isf.spring.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nishi on 2016-03-29.
 */
public class SearchEngineService implements SearchEngine {

    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);
    private DocumentDAO documentDAO;

    public SearchEngineService() {
        if(log.isDebugEnabled())
            log.debug("Utworzono egzemplarz klasy SearchEngineService: " + this);
    }
    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        if(log.isDebugEnabled())
            log.debug("Utworzono egzemplarz implementacji DocumentDAO: " + documentDAO);

        this.documentDAO = documentDAO;
    }

    public List<Document> findByType(Type documentType) {
        if(log.isDebugEnabled())
            log.debug("Początek metody findByType: " + documentType);

        List<Document> result = new ArrayList<Document>();
        for(Document document: listAll()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }

        if(log.isDebugEnabled())
            log.debug("Koniec metody findByType: " + result);

        return result;
    }

    public List<Document> listAll() {

        if(log.isDebugEnabled())
            log.debug("Początek metody listAll: ");

        List<Document> result = Arrays.asList(documentDAO.getAll());

        if(log.isDebugEnabled())
            log.debug("Koniec metody listAll: " + result);

        return result;
    }

}
