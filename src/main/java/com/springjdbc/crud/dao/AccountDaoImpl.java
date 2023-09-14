package com.springjdbc.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.crud.entity.Account;

@Component("accountDaoImpl")
public class AccountDaoImpl implements AccountDao{

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Account account) {
		try {
			String query = "INSERT INTO account(acc_number,acc_holder) VALUES(?,?)";
			int isInserted = this.jdbcTemplate.update(query,account.getAccNumber(),account.getAccHolder());
			return isInserted;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int update(Account account) {
		try {
			String query = "UPDATE account SET acc_number=?,acc_holder=? WHERE id=?";
			int isUpdate = this.jdbcTemplate.update(query,account.getAccNumber(),account.getAccHolder(),account.getId());
			return isUpdate;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int delete(int accId) {
		try {
			String query = "DELETE FROM account WHERE id=?";
			int isDeleted = this.jdbcTemplate.update(query,accId);
			return isDeleted;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Account getSingleAccount(int accId) {
		try {
			String query = "SELECT * FROM account WHERE id=?";
			RowMapper<Account> rowMapper = new AccountRowMapperImpl();
			Account account = this.jdbcTemplate.queryForObject(query, rowMapper,accId);
			return account;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Account> getAllAccount() {
		try {
			String query = "SELECT * FROM account";
			RowMapper<Account> rowMapper = new AccountRowMapperImpl();
			List<Account> accList = this.jdbcTemplate.query(query, rowMapper);
			return accList;
		} catch (Exception e) {
			return null;
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
