package dao;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */
public interface CrudDao<T,PK extends Serializable> {

    /** Persist the newInstance object into database */
    PK create(T o);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save changes made to a persistent object.  */
    void update(T o);

    /** Remove an object from persistent storage in the database */
    void delete(T o);
}
