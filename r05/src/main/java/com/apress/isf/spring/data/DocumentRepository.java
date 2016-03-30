package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
public class DocumentRepository implements DocumentDAO {

    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private List<Document> documents = null;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document[] getAll() {
        if(log.isDebugEnabled())
            log.debug("Początek metody getAll: ");

        Document[] result = documents.toArray(new Document[documents.size()]);

        if(log.isDebugEnabled())
            log.debug("Koniec metody getAll: " + result);

        return result;
    }
}
