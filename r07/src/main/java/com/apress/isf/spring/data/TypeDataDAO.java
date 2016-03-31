package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;

/**
 * Created by nishi on 2016-03-30.
 */
public interface TypeDataDAO {
    public Type[] getAll();
    public Type findById(String id);
}
