package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kylong on 2016/4/18.
 */
public interface BaseDao<T> {

    Serializable save(T o);

    T getById(Serializable id);

    void update(T o);

    void delete(T o);

    List<T> findByIds(Serializable[] ids);

    List<T> findAll();
}
