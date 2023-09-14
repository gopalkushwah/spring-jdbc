package com.springjdbc.crud;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.crud.dao.AccountDao;
import com.springjdbc.crud.entity.Account;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		AccountDao accountDaoImpl = context.getBean("accountDaoImpl",AccountDao.class);
		Scanner sc = new Scanner(System.in);
		boolean isOver = true;
		Account account = context.getBean("account",Account.class);
		while(isOver) {
			System.out.println("Insert - 1");
			System.out.println("update - 2");
			System.out.println("delete - 3");
			System.out.println("select single - 4");
			System.out.println("select all - 5");
			System.out.println("continue - 6");
			System.out.println("exit - 7");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			String accHolder,accNumber;
			int accId;
			switch(choice) {
				case 1:
					sc.nextLine();
					System.out.println("Enter Account Holder Name : ");
					accHolder = sc.nextLine();
					System.out.println("Enter Account Number : ");
					accNumber = sc.nextLine();
					account.setAccHolder(accHolder);
					account.setAccNumber(accNumber);
					int insert = accountDaoImpl.insert(account);
					if(insert>0)
						System.out.println("Account Details Inserted!");
					else
						System.out.println("Something went wrong!");
					
				break;
				case 2:
					sc.nextLine();
					System.out.println("Enter Acc Id Where you want to update : ");
					accId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Account Holder Name : ");
					accHolder = sc.nextLine();
					System.out.println("Enter Account Number : ");
					accNumber = sc.nextLine();
					account.setId(accId);
					account.setAccHolder(accHolder);
					account.setAccNumber(accNumber);
					int update = accountDaoImpl.update(account);
					if(update>0)
						System.out.println("Account Details Updated!");
					else
						System.out.println("Something went wrong!");
				break;
				case 3:
					sc.nextLine();
					System.out.println("Enter Acc Id To delete : ");
					accId = sc.nextInt();
					int isDeleted = accountDaoImpl.delete(accId);
					if(isDeleted>0)
						System.out.println("Account Details Deleted!");
					else
						System.out.println("Something went wrong!");
				break;
				case 4:
					sc.nextLine();
					System.out.println("Enter Acc Id: ");
					accId = sc.nextInt();
					account = accountDaoImpl.getSingleAccount(accId);
					if(account!=null)
						System.out.println(account);
					else
						System.out.println("Data Not Found");
				break;
				case 5:
					List<Account> accountList = accountDaoImpl.getAllAccount();
					if(accountList!=null) {
						for(Account acc : accountList)
							System.out.println(acc);
					}else
						System.out.println("Something went wrong");
				break;
				case 6:
					isOver = true;
				break;
				case 7:
					isOver = false;
				break;
				default:
					System.out.println("Wrong choice");
					
			}
			
		}
	}

}
