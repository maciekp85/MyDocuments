package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;

import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
public class DocumentRepository implements DocumentDAO {
    private List<Document> documents = null;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document[] getAll() {
        Document[] result = documents.toArray(new Document[documents.size()]);
        return result;
    }
}
