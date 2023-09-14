package com.springjdbc.selectingsingledata.dao;

import com.springjdbc.selectingsingledata.entity.Student;

public interface StudentDao {
	public Student getSingleData(int studentId);
}
