package service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kylong on 2016/4/18.
 */
public interface BaseService<T> {
    void save(T entity);

    void update(T entity);

    void delete(Serializable id);

    T getById(Serializable id);


    List<T> findByIds(Serializable[] ids);

    List<T> findAll();
}
