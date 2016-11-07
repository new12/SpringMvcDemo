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
        System.out.println("hello world");
    }

    public static void getClassName(Class<?> a) throws IllegalAccessException, InstantiationException {
        System.out.println(a.newInstance());
    }
}
