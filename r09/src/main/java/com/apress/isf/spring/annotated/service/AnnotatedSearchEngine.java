package com.apress.isf.spring.annotated.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {

    @Autowired
    private DocumentDAO documentDAO;

    public AnnotatedSearchEngine() {
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
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }
}
