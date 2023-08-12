package com.newtechage.services;

import com.newtechage.HibernateUtil;
import com.newtechage.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.sqm.tree.delete.SqmDeleteStatement;
import org.hibernate.query.sqm.tree.expression.SqmCaseSearched;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrudRepositoryServiceImpl<T,S> implements CrudRepository<T,S> {

    private final SessionFactory sessionFactory;
    private final Class<T> type;

    public CrudRepositoryServiceImpl(Class<T> type) {
        this.sessionFactory = HibernateUtil.getSessionFactoryInstance();
        this.type = type;
    }

    @Override
    public Set<T> findAll() {
        Set<T> result = new HashSet<>();
        String tableName = type.getSimpleName();
        try(Session session = sessionFactory.openSession()) {
            List<T> t = session.createQuery("FROM "+tableName).getResultList();
            result.addAll(t);
        }
        return result;
    }

    @Override
    public T findById(S id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(type,id);
        }
    }

    @Override
    public boolean save(T t) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            return true;
        }
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public boolean delete(S s) {
        return false;
    }

    @Override
    public boolean deleteById(S s) {
        return false;
    }
}
