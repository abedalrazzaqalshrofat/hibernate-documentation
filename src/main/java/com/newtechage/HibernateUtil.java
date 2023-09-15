package com.newtechage;

import com.newtechage.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil(){}


    public static SessionFactory getSessionFactoryInstance(){
        if (sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Product.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
