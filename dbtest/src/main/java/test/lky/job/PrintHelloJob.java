package test.lky.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by kylong on 2016/10/30.
 */

public class PrintHelloJob {
    @Scheduled(cron = "0 * * * * *")
    public void print(){
        System.out.println("hello, current time is " + new Date());
    }
}
