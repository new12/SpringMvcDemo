package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylong on 2016/4/19.
 */
public class GenericTest {
    public static <T extends String > void print(List<T> lst){
        for (T tmp : lst){
            System.out.println(tmp);
        }
    }

    public static void main(String[] args) {
        List<String> container = new ArrayList<String>();
        container.add("lky");
        container.add("123");
        print(container);
    }
}
