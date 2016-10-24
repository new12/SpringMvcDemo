package test.lky;
import org.junit.Assert;
import org.junit.Test;

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
}
