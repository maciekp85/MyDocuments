package com.apress.isf.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by nishi on 2016-04-23.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.apress.isf.spring")
public class MyDocumentsApp {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).
                addScript("META-INF/data/schema.sql").
                addScript("META-INF/data/data.sql").build();
        return db;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyDocumentsApp.class,args);
    }
}
