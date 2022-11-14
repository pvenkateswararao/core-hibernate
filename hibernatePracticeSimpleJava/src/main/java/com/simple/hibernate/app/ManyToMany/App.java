package com.simple.hibernate.app.ManyToMany;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure().
    	addAnnotatedClass(Movie.class)
    	.addAnnotatedClass(Actor.class);
    	
    	SessionFactory sf = configuration.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
    	Transaction trans = s.getTransaction();
    	
    	Actor pavan= new Actor();
    	pavan.setActor_name("Pavan Kalyan");
    	    	
    	Movie gabber = new Movie();
    	gabber.setMovie_name("GabberSing");
    	pavan.add(gabber);
    	Movie pspk = new Movie();
    	pspk.setMovie_name("PSPK 50");
    	pavan.add(pspk);
    	
    	s.beginTransaction();
    	
    	s.save(pavan);
    	
    	trans.commit();
    	
    	
    	
    	
    }
}
