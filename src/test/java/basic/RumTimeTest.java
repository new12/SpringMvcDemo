package basic;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * Created by kylong on 2016/4/27.
 */
public class RumTimeTest {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        List<String> list = bean.getInputArguments();
        for (int i= 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
