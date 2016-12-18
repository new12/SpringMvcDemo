package test.lky.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by kylong on 2016/11/22.
 */
//@Component
public class AsyncPrintHello {
    @Async
    public void asyncPrint(){
        System.err.println("thread id: " + Thread.currentThread().getId());
        System.err.println("hello");
    }
}
