package com.apress.isf.spring.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.apress.isf.java.model.Type;
import com.apress.isf.spring.data.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nishi on 2016-04-18.
 */
@Repository("mongoTypeDAO")
public class MongoTypeRepository implements TypeDAO {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public List<Type> getAll() {
        return mongoTemplate.findAll(Type.class);
    }

    @Override
    public Type findById(String id) {
        Query query = query(where("typeId").is(id));
        return mongoTemplate.findOne(query, Type.class);
    }

    @Override
    public Type save(Type type) {
        mongoTemplate.insert(type);
        return type;
    }

    @Override
    public void removeAll() {
        mongoTemplate.dropCollection("types");
    }
}
