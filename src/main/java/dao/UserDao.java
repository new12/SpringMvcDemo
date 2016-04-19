package dao;

import entity.Role;
import entity.User;

/**
 * Created by kylong on 2016/4/18.
 */
public interface UserDao extends BaseDao<User> {
    User findByName(String name);
}
