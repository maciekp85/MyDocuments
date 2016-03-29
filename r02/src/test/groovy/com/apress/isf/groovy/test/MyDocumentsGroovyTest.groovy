package com.apress.isf.groovy.test

import com.apress.isf.groovy.model.Document
import com.apress.isf.groovy.model.Type
import com.apress.isf.groovy.service.SearchEngine
import org.junit.Test
import static org.junit.Assert.*;

/**
 * Created by nishi on 2016-03-29.
 */
class MyDocumentsGroovyTest {

    @Test
    public void testFindByType() {
        def documents = engine.findByType(types.web)
        assertNotNull documents
        assertTrue documents.size() == 1
        assertEquals types.web.name, documents[0].type.getName()
        assertEquals types.web.desc, documents[0].type.getDesc()
        assertEquals types.web.extension, documents[0].type.getExtension()
    }

    @Test
    public void testListAll() {
        def documents = engine.listAll()
        assertNotNull documents
        assertTrue documents.size() == 4
    }

    def engine = [
            findByType: {type ->
                docs.findAll { it.type.name == type.name }
            },
            listAll: {
                docs
            } ] as SearchEngine

    def types = [
            pdf:new Type(name: "PDF", desc: "Portable Document Format", extension: ".pdf"),
            note:new Type(name: "NOTE", desc: "Notatki tekstowe", extension: ".txt"),
            web:new Type(name: "WEB", desc: "Lacze sieciowe", extension: ".url")]

    def docs = [
            new Document(name: "Szablon książki", type: types.pdf, location: "/Users/felipeg/Documents/Random/Book Template.pdf"),
            new Document(name:"Przykładowa umowa",type:types.pdf,location:"/Users/felipeg/Documents/Contracts/Sample Contract.pdf"),
            new Document(name:"Clustering with RabbitMQ",type:types.note,location:"/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"),
            new Document(name:"Pro Spring Security Book",type:types.web,location:"http://www.apress.com/9781430248187")]


}
