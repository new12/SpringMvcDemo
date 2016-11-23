package test.lky;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by kylong on 16/10/17.
 */
public class SimpleTest3 {
    public static void main(String[] args) {
        LinkedList list = mock(LinkedList.class);
        when(list.get(0)).thenReturn("first");
        when(list.get(1)).thenThrow(new RuntimeException());

        System.out.println(list.get(0));
//        System.out.println(list.get(1));
        System.out.println(list.get(999));

        verify(list,atLeast(2)).get(0);
    }

    @Test
    public void test(){
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("element");

        System.out.println(list.get(0));
        System.out.println(list.get(22));

        verify(list).get(21);
    }
}
