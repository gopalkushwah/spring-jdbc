package com.springjdbc.configurationUsingAnnotation;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springjdbc.configurationUsingAnnotation.dao.StudentDao;
import com.springjdbc.configurationUsingAnnotation.entity.Student;

public class App 
{
	private static AbstractApplicationContext context;
    public static void main( String[] args )
    {
        context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = context.getBean("student",Student.class);
        Scanner src = new Scanner(System.in);
//        taking user input
        System.out.println("Enter Student id :");
        int id = src.nextInt();
        System.out.println("Enter Student name :");
        src.nextLine();
        String name = src.nextLine();
        System.out.println("Enter Student name :");
        String city = src.nextLine();
        
//        setting student values
        student.setId(id);
        student.setName(name);
        student.setCity(city);
        
//        getting object of StudentDaoImpl from string container
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl",StudentDao.class);
        
//       calling method of StudentDaoImpl
        int result = studentDaoImpl.insert(student);
        
        System.out.println("data inserted : "+result);
        src.close();
        context.close();
    }
}
