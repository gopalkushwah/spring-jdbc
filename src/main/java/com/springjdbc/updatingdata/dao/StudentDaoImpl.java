package com.springjdbc.updatingdata.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.updatingdata.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int change(Student student) {
		String query = "UPDATE student SET name=?,city=? WHERE id=?";
		int isUpdate = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());		
		return isUpdate;
	}

	

}
