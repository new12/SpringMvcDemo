package dao;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public interface BaseDao<T,PK extends Serializable> {

    PK save(T o);

    T getById(PK id);

    void update(T o);

    void delete(T o);
}
