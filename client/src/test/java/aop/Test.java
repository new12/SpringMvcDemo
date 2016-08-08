package aop;

/**
 * Created by kylong on 2016/7/26.
 */
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Test {
    @org.junit.Test
    public void test1(){
        ClassPathResource res = new ClassPathResource("aop.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        factory.getBean("testAop");
    }
}
