import org.junit.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by kylong on 2016/6/21.
 */

public class JobClient {
    @Test
    public void  testTreeMap(){
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        map.put(5,1);
        map.put(2,1);
        map.put(3,1);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " "+entry.getValue());
        }
    }
    @Test
    public void testPriorityQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(2);
        queue.add(10);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
