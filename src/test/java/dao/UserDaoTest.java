package dao;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class UserDaoTest {
    @Autowired
    private UserDao dao;
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        dao.save(user);
    }
}
