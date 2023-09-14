package com.springjdbc.selectingalldata.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springjdbc.selectingalldata.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getAllStudent() {
		try {
			String query = "SELECT * FROM student";
			List<Student> students = this.jdbcTemplate.query(query, new StudentRowMapperImpl());
			return students;
		}catch (Exception e) {
			return null;
		}
	}
	
	

}
