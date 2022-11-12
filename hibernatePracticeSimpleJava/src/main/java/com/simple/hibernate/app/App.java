package com.simple.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simple.hibernate.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure().addAnnotatedClass(Employee.class);
    	
    	SessionFactory sf = configuration.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
    	Employee e = new Employee();
    	e.setName("Trinadh");
    	e.setSalary("900000");
    	
    	s.beginTransaction();
    	s.save(e);
    	s.getTransaction().commit();
        System.out.println( "Saved in DB " + s );
    }
}
