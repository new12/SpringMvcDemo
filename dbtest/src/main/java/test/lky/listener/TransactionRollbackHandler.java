package test.lky.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kylong on 2016/11/23.
 */
@Component
public class TransactionRollbackHandler {
    @TransactionalEventListener(phase= TransactionPhase.AFTER_COMMIT)
    public void handlerException(ExceptionEvent event){
        System.out.println("roll back");
    }

    public static void main(String[] args) {
        Map map = getMap();
        Map<Integer,Object> map1 = map;
    }

   static Map<Integer,List<Integer>> getMap(){
        Map<Integer,List<Integer>> test = new HashMap<>();
        test.put(1, Arrays.asList(1,2,3));
        return test;
    }
}
