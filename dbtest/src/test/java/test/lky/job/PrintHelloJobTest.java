package test.lky.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylong on 2016/10/30.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-schedule.xml")
public class PrintHelloJobTest {

    @Test
    public void test(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-schedule.xml");
        AsyncPrintHello hello = (AsyncPrintHello) context.getBean("asyncPrintHello");
        System.err.println("thread id: " + Thread.currentThread().getId());
        hello.asyncPrint();

    }
}
