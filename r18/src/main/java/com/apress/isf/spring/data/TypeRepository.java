/**
 * 
 */
package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Felipe Gutierrez
 *
 */
@Repository("typeDAO")
public class TypeRepository implements TypeDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Type> getAll() {
		return new JdbcTemplate(dataSource).query("select * from types",
				new TypeRowMapper());
	}

	@Override
	public Type findById(String id) {
		return new JdbcTemplate(dataSource).queryForObject("select * from types where typeId = ?", new Object[] {id},
				new TypeRowMapper());
	}

	public Type save(Type type){
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	@Override
	public void removeAll() {

	}
}
