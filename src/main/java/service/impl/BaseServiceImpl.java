package service.impl;

import dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseService;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public  class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseDao<T,Serializable> baseDao;

    public BaseServiceImpl(BaseDao<T,Serializable> dao){
            this.baseDao = dao;
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(getById(id));
    }

    @Override
    public T getById(Serializable id) {
        return baseDao.getById(id);
    }

}
