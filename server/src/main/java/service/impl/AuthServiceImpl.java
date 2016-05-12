package service.impl;

import dao.JobDao;
import dao.RoleDao;
import dao.UserDao;
import entity.Job;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AuthService;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByName(username);
        boolean isEnable = user.getActive();
        Set<Role> roles = user.getRoles();
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),isEnable,true,true,true,roles);
    }

    @Override
    public void grantRolesToUser(Integer userId, Integer[] roleIds) {
        User user = userDao.getById(userId);
        if (user == null) throw new RuntimeException();
        List<Role> roles = roleDao.findByIds(roleIds);
        for (Role e : roles) {
            user.getRoles().add(e);
        }
    }

}
