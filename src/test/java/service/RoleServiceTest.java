package service;

import basic.BasicTest;
import entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kylong on 2016/4/19.
 */
public class RoleServiceTest extends BasicTest {
    @Autowired
    private RoleService service;
    @Test
    public void testSave(){
        Role role = new Role();
        role.setName("user");
        service.save(role);
    }
}
