package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
public interface SearchEngine {
    public List<Document> findByType(Type type);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
    public Document findById(String id);
}
