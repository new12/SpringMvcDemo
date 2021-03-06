package service.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.BaseService;
import service.UserService;

/**
 * Created by kylong on 2016/4/18.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @PreAuthorize("principal.username ==#name")
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
