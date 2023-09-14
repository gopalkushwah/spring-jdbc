package com.springjdbc.configurationUsingAnnotation;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.springjdbc.configurationUsingAnnotation.dao.StudentDao;
import com.springjdbc.configurationUsingAnnotation.dao.StudentDaoImpl;
import com.springjdbc.configurationUsingAnnotation.entity.Student;

@Configuration
public class JavaConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean("studentDaoImpl")
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.setJdbcTemplate(getJdbcTemplate());
		return studentDaoImpl;
	}
	
	@Bean("student")
	@Scope("prototype")
	public Student getStudent() {
		return new Student();
	}
	
	
}
