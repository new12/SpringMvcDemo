package service;

import basic.BasicTest;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Test
    public void testFindByIds(){
        Integer[] ids = new Integer[2];
        ids[0] = new Integer(1);
        List<User> users = service.findByIds(ids);
        System.out.println(users);
    }

}
