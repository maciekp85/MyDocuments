package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
@Repository("documentDAO")
public class DocumentRepository implements DocumentDAO {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private String query;

    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(query, new DocumentRowMapper());
    }
}
