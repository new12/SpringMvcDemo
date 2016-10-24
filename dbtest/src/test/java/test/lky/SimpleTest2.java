package test.lky;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Created by didi on 16/10/17.
 */
public class SimpleTest2{
    @Test
    public void test(){
        List mockList = mock(List.class);
        mockList.add("one");
        mockList.clear();
        mockList.add("two");

        verify(mockList).add("one");
        verify(mockList).clear();
        verify(mockList).add("2");
    }
}
