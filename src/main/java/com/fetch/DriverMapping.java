package com.fetch;


import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class DriverMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Creating Employee
		Employee emp1 = new Employee();
		emp1.setId(1234);
		emp1.setName("John");
		emp1.setAge(21);
//		Creating account details for emp1
		Account ac1 = new Account();
		ac1.setAccNo(13234);
		ac1.setBankName("icici");
		ac1.setEmp(emp1);
		
		Account ac2 = new Account();
		ac2.setAccNo(13235);
		ac2.setBankName("hdfc");
		ac2.setEmp(emp1);
		Account ac3 = new Account();
		ac3.setAccNo(13236);
		ac3.setBankName("idusind");
		ac3.setEmp(emp1);
		
//		Creating list to add the accounts to employee
		List<Account> list = new ArrayList<Account>();
		list.add(ac1);
		list.add(ac2);
		list.add(ac3);
		
//		Adding account to employee
		emp1.setAccD(list);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp1);
		session.save(ac1);
		session.save(ac2);
		session.save(ac3);
		
		
		tx.commit();
		
		Employee xyz = session.get(Employee.class, 1234);
//		System.out.println("Employee name is " + xyz.getName());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Employee name is " + xyz.getName());
		System.out.println("Employee age is "  + xyz.getAge());
//		System.out.println("Display all the deatils of account");
//		List<Account> lt = xyz.getAccD();
//		for(Account x : lt) {
//			System.out.println( "Account no is " + x.getAccNo());
//			System.out.println( " Bank name is " + x.getBankName());
//		}
		session.close();
		factory.close();
		
		
		
		
		
	}

}
