package service.impl;

import dao.JobDao;
import dao.PrivilegeDao;
import dao.RoleDao;
import dao.UserDao;
import entity.Job;
import entity.Privilege;
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
    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private JobDao jobDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByName(username);
        boolean isEnable = user.getActive();
        Set<Role> roles = user.getRoles();
        Set<Privilege> allPrivileges = new HashSet<Privilege>();
        for (Role r : roles){
            allPrivileges.addAll(r.getPrivileges());
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),isEnable,true,true,true,allPrivileges);
    }

    @Override
    public void grantRolesToUser(Integer userId, Integer[] roleIds) {
        User user = userDao.getById(userId);
        if (user == null) throw new RuntimeException();
        List<Role> roles = roleDao.findByIds(roleIds);
        for (Role e : roles){
            user.getRoles().add(e);
        }
    }

    @Override
    public void grantPrivilegesToRole(Integer roleId, Integer[] privilegeIds) {
        Role role = roleDao.getById(roleId);
        if (role == null) throw  new RuntimeException();
        List<Privilege> privileges = privilegeDao.findByIds(privilegeIds);
        for (Privilege e : privileges){
            role.getPrivileges().add(e);
        }
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        if (targetDomainObject instanceof  Job){
            Job target = (Job)targetDomainObject;
            if (!target.getUser().equals(principal.getUsername()))return  false;
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            for (GrantedAuthority auth : authorities) {
                if (auth.getAuthority().equals(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        if (targetType.equals("entity.Job")){
            Job target = jobDao.getById(targetId);
            if (!target.getUser().equals(principal.getUsername()))return  false;
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            for (GrantedAuthority auth : authorities) {
                if (auth.getAuthority().equals(permission)) {
                    return true;
                }
            }
        }
        return false;
    }
}
