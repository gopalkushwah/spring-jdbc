package com.springjdbc.selectingalldata;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.selectingalldata.dao.StudentDao;
import com.springjdbc.selectingalldata.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/selectingalldata/config.xml");
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl",StudentDao.class);
        List<Student> allStudents = studentDaoImpl.getAllStudent();
        for(Student student : allStudents) {
        	System.out.println(student);
        }
        
        
    }
}
