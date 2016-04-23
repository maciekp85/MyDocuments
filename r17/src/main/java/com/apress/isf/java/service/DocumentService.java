package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.List;

/**
 * Created by nishi on 2016-04-06.
 */
public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public List<Document> findByType(Type type);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public boolean updateLocationFromDocumentId(String documentId, String location);
}
