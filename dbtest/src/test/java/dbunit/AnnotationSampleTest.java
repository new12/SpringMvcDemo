package dbunit;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.lky.model.User;
import test.lky.service.UserServiceImpl;

/**
 * Created by kylong on 2016/10/24.
 */

public class AnnotationSampleTest extends BaseTest{
    @Autowired
    private UserServiceImpl userService;

    @Test
    @DatabaseSetup("/dbunit/user.xml")
    public void testSelect(){
        User user = userService.get(1);
        Assert.assertEquals("lily",user.getName());
    }

    @Test
    @DatabaseSetup("/dbunit/user.xml")
    public void testInsert(){
        User user = new User();
        user.setName("aka");
        user.setPassword("123456");
        user.setActive(1);
        //row为受影响的行数
        int row = userService.insert(user);
        User user1 = userService.get(4);
        Assert.assertEquals("aka",user1.getName());
    }
}
