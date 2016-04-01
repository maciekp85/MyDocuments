package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;

import java.util.Map;

/**
 * Created by nishi on 2016-03-30.
 */
public class TypeDataRepository implements TypeDataDAO {

    private Map<String, Type> types = null;

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    public Type findById(String id) {
        Type type = types.get(id);
        return type;
    }

    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }
}
