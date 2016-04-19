package dao.Impl;

import dao.UserDao;
import entity.Role;
import entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
