package test.lky;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import test.lky.model.User;
import test.lky.service.UserService;
import static  org.mockito.Mockito.*;


/**
 * Created by kylong on 2016/10/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserServiceTest {
    @Mock
    private UserService mockuserService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        User user = new User();
        user.setId(1);
        user.setName("hi");
        user.setPassword("password");
        when(mockuserService.getUser(anyInt())).thenReturn(user);
    }

    @Test
    public void testGetUser(){
        User user = mockuserService.getUser(1);
        Assert.assertEquals("hi",user.getName());
        Assert.assertEquals("password",user.getPassword());
    }
}
