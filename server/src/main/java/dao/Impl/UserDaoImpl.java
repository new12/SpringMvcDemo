package dao.impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByName(String name) {
        String hql = "from " + getSessionFactory().getClassMetadata(User.class).getEntityName() + " where name = :name";
        Query query = getSession().createQuery(hql);
        query.setParameter("name", name );
        return  (User)query.uniqueResult();
    }
}
