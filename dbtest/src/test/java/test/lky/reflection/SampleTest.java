package test.lky.reflection;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import test.lky.Reflection.Sample;

/**
 * Created by longkeyu on 2016/12/22.
 */
public class SampleTest {
    @Test
    public void test(){
        Sample sample = new Sample();
        ReflectionTestUtils.setField(sample, "id", 1);
        ReflectionTestUtils.setField(sample, "name", "kevin");
        Object[] args = null;
        ReflectionTestUtils.invokeMethod(sample, "getAll", args);
    }
}
