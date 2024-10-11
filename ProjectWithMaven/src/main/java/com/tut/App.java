package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setId(101);
        st.setName("Shubham");
        st.setCity("Bengaluru");
        System.out.println(st);
        
        Session session =  factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        
        session.close();
    }
}
