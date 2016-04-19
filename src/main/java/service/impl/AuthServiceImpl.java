package service.impl;

import entity.Privilege;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AuthService;
import service.RoleService;
import service.UserService;

import java.util.List;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void grantRolesToUser(Integer userId, Integer[] roleIds) {
        User user = userService.getById(userId);
        if (user == null) throw new RuntimeException();
        List<Role> roles = roleService.findByIds(roleIds);
        for (Role e : roles){
            user.getRoles().add(e);
        }
    }

    @Override
    public void grantPrivilegesToRole(Integer roleId, Integer[] privilegeIds) {
        
    }
}
