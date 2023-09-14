package com.springjdbc.deletingdata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.deletingdata.dao.StudentDao;
public class App 
{
	private static ApplicationContext context;
    public static void main( String[] args )
    {
        context = new ClassPathXmlApplicationContext("com/springjdbc/deletingdata/config.xml");
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl",StudentDao.class);
        int isDeleted = studentDaoImpl.delete(105);
        if(isDeleted >0) {
        	System.out.println("data updated");
        }else {
        	System.out.println("info not found");
        }
        
    }
}
