package dao.Impl;

import dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kylong on 2016/4/18.
 */
public  class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> type;
    public BaseDaoImpl(Class<T> type){
        this.type = type;
    }
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(T newInstance) {
        return (Serializable)getSession().save(newInstance);
    }

    @Override
    public T getById(Serializable id) {
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

    @Override
    public List<T> findByIds(Serializable[] ids) {
        String hql = "from " + sessionFactory.getClassMetadata(type).getEntityName() + " entity where entity.id in (:ids)";
        Query query = getSession().createQuery(hql);
        query.setParameterList("ids", ids);
        return  query.list();
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + sessionFactory.getClassMetadata(type).getEntityName();
        Query query = getSession().createQuery(hql);
        return  query.list();
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
