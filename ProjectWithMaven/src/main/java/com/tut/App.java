package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Creating object of Student class
        Student st = new Student();
        st.setId(101);
        st.setName("Shubham");
        st.setCity("Bengaluru");
        System.out.println(st);
        
        // Creating object of Address class
        Address ad = new Address();
        ad.setStreet("Telecom Road");
        ad.setCity("Bengaluru");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/shubham_pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session =  factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done..");
    }
}
