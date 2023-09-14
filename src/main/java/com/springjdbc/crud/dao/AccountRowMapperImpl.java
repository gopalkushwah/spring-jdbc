package com.springjdbc.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import com.springjdbc.crud.JavaConfig;
import com.springjdbc.crud.entity.Account;

public class AccountRowMapperImpl implements RowMapper<Account>{
	private ApplicationContext context;

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Account account = context.getBean("account",Account.class);
		account.setId(rs.getInt(1));
		account.setAccNumber(rs.getString(2));
		account.setAccHolder(rs.getString(3));
		return account;
	}

}
