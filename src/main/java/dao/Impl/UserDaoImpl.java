package dao.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class UserDaoImpl extends CrudDaoImpl<User,Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
