package com.hackathon.jersey.backend.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateSessionUtil {
    
    private static HibernateSessionUtil instance=new HibernateSessionUtil();
    private SessionFactory sessionFactory;
    
    public static HibernateSessionUtil getInstance(){
            return instance;
    }
    
    private HibernateSessionUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();
        return session;
    }
}
