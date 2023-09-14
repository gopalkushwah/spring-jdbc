package com.springjdbc.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/springjdbc/config.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        String query = "INSERT INTO student(id,name,city) values(?,?,?)";
        
        int result = jdbcTemplate.update(query,102,"Ram","Bhopal");
        System.out.println("row inserted "+result);
        
    }
}
