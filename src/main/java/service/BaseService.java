package service;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public interface BaseService<T> {
    public void save(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public T getById(Serializable id);
}
