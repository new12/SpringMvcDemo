package bean;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by kylong on 2016/7/26.
 */
public class C implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("c calll afterPropertiesSet");
    }
}
