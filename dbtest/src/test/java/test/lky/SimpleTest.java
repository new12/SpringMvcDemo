package test.lky;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by didi on 16/10/16.
 */
public class SimpleTest {
    @Test
    public void simpleTest(){
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("helloworld");
        String results = list.get(0);
        verify(list).get(0);
        Assert.assertEquals("helloworld",results);
    }

    @Test
    public void testRemove(){
        List<model> list = new ArrayList<>();
        model m = new model(1);
        list.add(m);
        model m1 = new model(2);
        list.add(m1);
        System.out.println(list.size());
        list.remove(m);
        System.out.println(list.size());
    }

    public static class model{
        public int a;
        public model(int a){
            this.a = a;
        }
    }
}
