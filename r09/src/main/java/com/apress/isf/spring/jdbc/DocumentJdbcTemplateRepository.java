package com.apress.isf.spring.jdbc;

import com.apress.isf.java.model.Document;
import com.apress.isf.spring.data.DocumentDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by nishi on 2016-04-02.
 */
public class DocumentJdbcTemplateRepository implements DocumentDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private String query;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Document > getAll() {
        return jdbcTemplate.query(query, new DocumentRowMapper());
    }
}
