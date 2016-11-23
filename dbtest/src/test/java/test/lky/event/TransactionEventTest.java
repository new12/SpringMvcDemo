package test.lky.event;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import test.lky.model.User;
import test.lky.service.UserService;

/**
 * Created by kylong on 2016/11/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config-test.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@Transactional
@Rollback(value = false)
@DbUnitConfiguration(databaseConnection = "dataSource")
public class TransactionEventTest {
    @Autowired
    private UserService userService;
    @Test
    @DatabaseSetup("/dbunit/user.xml")
    public void test(){
        User user = new User();
        user.setName("aka");
        user.setPassword("123456");
        user.setActive(1);
        //row为受影响的行数
        int row = userService.insert(user);
//        throw new RuntimeException();

    }
}
