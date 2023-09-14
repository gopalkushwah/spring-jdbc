package com.springjdbc.selectingsingledata.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.selectingsingledata.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Student getSingleData(int studentId) {
		try {
		String query = "SELECT * FROM student WHERE id=?";
		RowMapper<Student> rowMapper = new StudentRowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
		}catch (Exception e) {
			return null;
		}
	}

	

}
