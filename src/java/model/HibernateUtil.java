/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Sera
 */
public class HibernateUtil {
    /*
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    */
    
    
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            //Configuration configuration = new Configuration().configure();
            
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            /*
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
            */
        }
         
        return sessionFactory;
    }
    
    //private static final SessionFactory sessionFactory;
    
    //static {
    //    try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            /*
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            */
            
            //Configuration configuration = new Configuration().configure();
            //StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            //applySettings(configuration.getProperties());
            //SessionFactory factory = configuration.buildSessionFactory(builder.build());
            
            /*
            if (sessionFactory == null) {
                // loads configuration and mappings
                Configuration configuration = new Configuration().configure();
                ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                // builds a session factory from the service registry
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
            }
            */
    //    } catch (Throwable ex) {
    //        // Log the exception. 
    //        System.err.println("Initial SessionFactory creation failed." + ex);
    //        throw new ExceptionInInitializerError(ex);
    //    }
    //}

    
    //public static SessionFactory getSessionFactory() {
    //    return sessionFactory;
    //}
}
