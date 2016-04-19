package service;

import basic.BasicTest;
import entity.Role;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kylong on 2016/4/19.
 */
public class AuthServiceTest extends BasicTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Test
    public void testGrantRolesToUser(){
        authService.grantRolesToUser(1,new Integer[]{1});
    }
}
