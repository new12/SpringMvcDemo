package test.lky;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Created by lky on 16/10/17.
 */
public class SimpleTest2{
    @Test
    public void test(){
        List mockList = mock(List.class);

        when(mockList.get(3)).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 5;
            }
        });
        System.out.println(mockList.get(3));
    }
}
