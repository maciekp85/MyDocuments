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

    private DocumentDAO documentDAO;

    public SearchEngineService() {
    }
    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
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
        List<Document> result = documentDAO.getAll();
        return result;
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("Metoda findByLocation jest jeszcze niezaimplementowana.");
    }

}
