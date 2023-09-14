package com.springjdbc.crud.dao;

import java.util.List;

import com.springjdbc.crud.entity.Account;

public interface AccountDao {
	public int insert(Account account);
	
	public int update(Account account);
	
	public int delete(int accId);
	
	public Account getSingleAccount(int accId);
	
	public List<Account> getAllAccount();
}
