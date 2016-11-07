package dao.impl.jpa;

import dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kylong on 2016/8/8.
 */
public class BaseDaoJpaImpl<T> implements BaseDao<T> {
    @PersistenceContext
    protected EntityManager em;
    @PersistenceUnit
    protected EntityManagerFactory emf;

    private Class<T> type;
    public BaseDaoJpaImpl(Class<T> type){
        this.type = type;
    }

    @Override
    public void save(T o) {
        em.persist(o);
    }

    @Override
    public T getById(Serializable id) {
        return em.find(type,id);
    }

    @Override
    public void update(T o) {
        em.merge(o);
    }

    @Override
    public void delete(T o) {
        em.remove(o);
    }

    @Override
    public List<T> findByIds(Serializable[] ids) {
        String hql = "from " + emf.getMetamodel().entity(type).getName() + " entity where entity.id in (:ids)";
        return em.createQuery(hql).setParameter("ids",ids).getResultList();
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
