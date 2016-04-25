package service;

import entity.Privilege;
import entity.Role;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by kylong on 2016/4/19.
 */
public interface AuthService extends UserDetailsService,PermissionEvaluator {
    public void grantRolesToUser(Integer userId, Integer[] roleIds);
    public void grantPrivilegesToRole(Integer roleId, Integer[] privilegeIds);
}
