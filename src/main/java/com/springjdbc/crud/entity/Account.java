package com.springjdbc.crud.entity;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String accNumber;
	private String accHolder;
	public Account() {
		super();
	}
	
	public Account(int id, String accNumber, String accHolder) {
		super();
		this.id = id;
		this.accNumber = accNumber;
		this.accHolder = accHolder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accNumber=" + accNumber + ", accHolder=" + accHolder + "]";
	}
	
	
}
