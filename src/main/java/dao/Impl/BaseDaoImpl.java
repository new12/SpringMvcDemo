package dao.Impl;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public  class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T,PK> {
    private Class<T> type;
    public BaseDaoImpl(Class<T> type){
        this.type = type;
    }
    private SessionFactory sessionFactory;

    @Override
    public PK save(T newInstance) {
        return (PK)getSession().save(newInstance);
    }

    @Override
    public T getById(PK id) {
        return (T)getSession().get(type,id);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
