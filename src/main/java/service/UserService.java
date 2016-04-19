package service;

import entity.Role;
import entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by kylong on 2016/4/18.
 */

public interface UserService extends UserDetailsService,BaseService<User> {
    public void addRole(Role role);
}
