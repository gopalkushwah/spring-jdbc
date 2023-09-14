package com.springjdbc.crud;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.springjdbc.crud.entity.Account;

@Configuration
@ComponentScan(basePackages = "com.springjdbc.crud.dao")
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
	
//	@Bean("accountDaoImpl")
//	public AccountDao getAccountDao() {
//		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
//		accountDaoImpl.setJdbcTemplate(getJdbcTemplate());
//		return accountDaoImpl;
//	}
	
	@Bean("account")
	public Account getAccount() {
		return new Account();
	}
}
