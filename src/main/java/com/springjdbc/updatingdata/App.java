package com.springjdbc.updatingdata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.updatingdata.dao.StudentDao;
import com.springjdbc.updatingdata.entity.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/updatingdata/config.xml");
        
        Student student = context.getBean("student",Student.class);
        student.setId(101);
        student.setName("Ram Kumar verma");
        student.setCity("Gumnam");
        
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl",StudentDao.class);
        int isUpdated = studentDaoImpl.change(student);
        
        if(isUpdated>0) {
        	System.out.println("data updated");
        }else {
        	System.out.println("info not found");
        }
        
    }
}
