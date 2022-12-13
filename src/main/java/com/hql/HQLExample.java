package com.hql;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.criteria.CriteriaQuery;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.fetch.Account;

public class HQLExample {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ss = factory.openSession();
		
//		Creating HQL query
//		String q = "from Account where AccNo = 13234 ";
		
//		Passing Dynamic query
		String query = "from Account where AccNo =:x ";
		
		
		Query q1 = ss.createQuery(query);
		
		
//		UsingsetParameter() method to store value
		q1.setParameter("x", 13234);
		List<Account> list = q1.list();
		System.out.println("All the name of the bank -->>");
		for (Account ac : list) {
			System.out.println(ac.getBankName());
			
		}
		
		System.out.println("-----------------------------------------------------------------------");
		
		String query1 = "delete from Account where AccNo =: a";
		
		Query q2 = ss.createQuery(query1);
		q2.setParameter("a", 13235 );
		
//		Calling method to do the delete operation
		
		Transaction tx = ss.beginTransaction();
		int r = q2.executeUpdate();
		System.out.println(r);
		
		tx.commit();
		
		
		
		
		
		
		
		ss.close();
		factory.close();
	}

}
