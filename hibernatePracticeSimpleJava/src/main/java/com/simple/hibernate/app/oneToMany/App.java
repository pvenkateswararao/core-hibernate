package com.simple.hibernate.app.oneToMany;


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
    	addAnnotatedClass(Customer.class)
    	.addAnnotatedClass(Order.class);
    	
    	SessionFactory sf = configuration.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
    	Transaction trans = s.getTransaction();
    	
    	Customer customer= new Customer();
    	customer.setName("Trinadh");
    	
    	Order order1 = new Order();
    	order1.setItem("AC");
    	order1.setCost("110000");
    	order1.setCustomer(customer);   //We need to add customer reference to order because order class in the owner
    	
    	Order order2 = new Order();
    	order2.setItem("TV");
    	order2.setCost("120000");
    	order2.setCustomer(customer);
    	
    	ArrayList<Order> orders = new ArrayList<Order>();
    	
    	orders.add(order1);
    	orders.add(order2);
    	
    	customer.setOrders(orders);
    	
    	s.beginTransaction();
    	
    	s.save(customer);
    	
    	trans.commit();
    	
    	
    	
    	
    }
}
