/**
 * 
 */
package com.apress.isf.spring.service;

import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.TypeService;
import com.apress.isf.spring.data.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Felipe Gutierrez
 *
 */
@Service("typeFacade")
public class TypeServiceFacade implements TypeService {

	@Autowired
	TypeDAO typeDAO;
	
	@Override
	public void createNewType(Type type) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	
	@Override
	public void updateType(Type type) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void removeTypeById(String id) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Override
	public List<Type> getAllDefinedTypes() {
		return typeDAO.getAll();
	}
	
	@Override
	public Type getTypeById(String id) {
		return typeDAO.findById(id);
	}

}
