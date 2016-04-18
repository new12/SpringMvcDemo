package dao.Impl;

import dao.CrudDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public  class CrudDaoImpl<T, PK extends Serializable> implements CrudDao<T,PK> {
    private Class<T> type;
    public CrudDaoImpl(Class<T> type){
        this.type = type;
    }
    private SessionFactory sessionFactory;

    @Override
    public PK create(T newInstance) {
        return (PK)getSession().save(newInstance);
    }

    @Override
    public T read(PK id) {
        return (T)getSession().get(type,id);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().update(o);
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
