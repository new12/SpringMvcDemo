package test.lky;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import test.lky.model.User;
import test.lky.service.UserService;

/**
 * Created by kylong on 2016/10/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testGetUser(){
        User user = userService.getUser(1);
        System.out.println(user.getName());
    }
}
