package com.springjdbc.configurationUsingAnnotation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.springjdbc.configurationUsingAnnotation.entity.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		String query = "INSERT INTO student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
