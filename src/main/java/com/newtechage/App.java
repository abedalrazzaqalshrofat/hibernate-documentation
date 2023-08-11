package com.newtechage;

import com.newtechage.entity.Product;
import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class App{
    public static void main( String[] args ) {

        try(Session session = HibernateUtil.getSessionFactoryInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = new Product();
            product.setProductName("Keyboard");
            session.persist(product);
            transaction.commit();
        }

    }
}
