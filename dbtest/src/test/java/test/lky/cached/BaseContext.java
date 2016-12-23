package test.lky.cached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import test.lky.express.BaseTest;
import test.lky.express.StudentBean;

/**
 * Created by longkeyu on 2016/12/23.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring-expression.xml"})
@DirtiesContext
public class BaseContext {
    @Autowired
    private StudentBean student;
    @Autowired
    private ApplicationContext context;
    @Test
    public void test1(){
        System.out.println(student.getName());
        student.setName("kevin");
        System.out.println(context);
    }
    @Test
    public void test2(){
        System.out.println(student.getName());
        System.out.println(context);
    }
}
