package com.springjdbc.selectingalldata.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import com.springjdbc.selectingalldata.entity.Student;

public class StudentRowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/selectingalldata/config.xml");
		Student student = context.getBean("student",Student.class);
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		return student;
	}

}
