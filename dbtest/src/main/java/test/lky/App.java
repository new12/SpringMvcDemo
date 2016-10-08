package test.lky;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        Class a = new String().getClass();
        Class b = new Integer(1).getClass();
        getClassName(a);
        List<?> ss = new ArrayList<>();
    }

    public static void getClassName(Class<?> a) throws IllegalAccessException, InstantiationException {
        System.out.println(a.newInstance());
    }
}
