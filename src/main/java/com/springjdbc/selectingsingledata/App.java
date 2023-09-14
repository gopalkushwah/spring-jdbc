package com.springjdbc.selectingsingledata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.selectingsingledata.dao.StudentDao;
import com.springjdbc.selectingsingledata.dao.StudentDaoImpl;
import com.springjdbc.selectingsingledata.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/selectingsingledata/config.xml");
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl",StudentDao.class);
        Student student = studentDaoImpl.getSingleData(105);
        if(student!=null) {
	        System.out.println(student.getId());
	        System.out.println(student.getName());
	        System.out.println(student.getCity());
        }else {
        	System.out.println("Data not found");
        }
        
        
    }
}
