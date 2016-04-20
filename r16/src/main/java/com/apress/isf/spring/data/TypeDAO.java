/**
 * 
 */
package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;

import java.util.List;

/**
 * @author Felipe Gutierrez
 *
 */
public interface TypeDAO {
	public List<Type> getAll();
	public Type findById(String id);
	public Type save(Type type);
	public void removeAll();
}
