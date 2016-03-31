package com.apress.isf.spring.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nishi on 2016-03-31.
 */
@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine {

    public List<Document> findByType(Type documentType) {
        throw new UnsupportedOperationException("Srodowisko QA. Operacja jeszcze niezaimplementowana.");
    }

    public List<Document> listAll() {
        throw new UnsupportedOperationException("Srodowisko QA. Operacja jeszcze niezaimplementowana.");
    }

}
