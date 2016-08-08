package bean;

import javafx.application.Application;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by kylong on 2016/7/25.
 */
public class Test {
    @org.junit.Test
    public void test(){
        ClassPathResource res = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        factory.getBean("d");
    }
    @org.junit.Test
    public void test2(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("bean.xml");
        context.getBean("a");
    }
}
