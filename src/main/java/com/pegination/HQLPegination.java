package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.fetch.Account;

public class HQLPegination {

	public static void main(String[] args) {
		
	  SessionFactory factory = new Configuration().configure().buildSessionFactory();

	  Session s = factory.openSession();
	  
	  Query qry = s.createQuery("from Account");
	  
	  qry.setFirstResult(1);
	  qry.setMaxResults(2);
	  
	  List<Account> list = qry.list();
	  
	  for(Account ac : list) {
		  System.out.println(ac.getAccNo() +" : "+ ac.getBankName() + " : " );
	  }
	  s.close();
	  factory.close();
	}

}
