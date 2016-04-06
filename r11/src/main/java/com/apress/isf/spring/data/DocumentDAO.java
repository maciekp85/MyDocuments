package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;

import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
public interface DocumentDAO {
    public List<Document> getAll();
    public void save(Document document);
    public Document findById(String id);
}
