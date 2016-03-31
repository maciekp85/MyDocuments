package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by nishi on 2016-03-30.
 */
public class TypeDataRepository implements TypeDataDAO {

    private static final Logger log = LoggerFactory.getLogger(TypeDataRepository.class);
    private Map<String, Type> types = null;

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    public Type findById(String id) {
        if(log.isDebugEnabled())
            log.debug("Początek metody findById: " + id);

        Type type = types.get(id);

        if(log.isDebugEnabled())
            log.debug("Koniec metody findById: " + type);

        return type;
    }

    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }
}
