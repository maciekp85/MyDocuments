/**
 * 
 */
package com.apress.isf.spring.data;

import com.apress.isf.java.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Felipe Gutierrez
 *
 */
public class TypeRowMapper implements RowMapper<Type>{

	@Override
	public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
		Type type = new Type(rs.getString("typeId"),
				rs.getString("name"),
				rs.getString("description"),
				rs.getString("extension"));
		return type;
	}

}
