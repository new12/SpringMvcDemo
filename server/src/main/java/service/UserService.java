package service;

import entity.Role;
import entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.Serializable;

/**
 * Created by kylong on 2016/4/18.
 */

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
