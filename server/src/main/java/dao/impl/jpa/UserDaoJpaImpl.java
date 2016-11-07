package dao.impl.jpa;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kylong on 2016/8/8.
 */
@Repository
@Transactional
public class UserDaoJpaImpl extends BaseDaoJpaImpl<User> implements UserDao {
    public UserDaoJpaImpl() {
        super(User.class);
    }

    @Override
    public User findByName(String name) {
        String sql = "from User u where u.name like :name";
        return (User) em.createQuery(sql).setParameter("name", name).getSingleResult();
    }
}
