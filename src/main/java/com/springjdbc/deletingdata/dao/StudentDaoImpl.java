package com.springjdbc.deletingdata.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int delete(int studentId) {
		String query = "DELETE FROM student WHERE id=?";
		int isDelete = this.jdbcTemplate.update(query,studentId);
		return isDelete;
	}
}
