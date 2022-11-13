package com.simple.hibernate.app.oneToOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simple.hibernate.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure().
    	addAnnotatedClass(Customer.class)
    	.addAnnotatedClass(AccessCard.class);
    	
    	SessionFactory sf = configuration.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
    	Transaction trans = s.beginTransaction();
    	
    	
    	
    	
    	trans.commit();
    	
    	
    	
    }
}
