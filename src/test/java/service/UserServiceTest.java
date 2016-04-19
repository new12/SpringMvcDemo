package service;

import basic.BasicTest;
import config.RootConfig;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylong on 2016/4/18.
 */

public class UserServiceTest extends BasicTest {
    @Autowired
    private UserService service;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        service.save(user);
    }

}
