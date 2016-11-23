package test.lky.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by kylong on 2016/11/23.
 */
@Component
public class TransactionRollbackHandler {
    @TransactionalEventListener(phase= TransactionPhase.AFTER_COMMIT)
    public void handlerException(ExceptionEvent event){
        System.out.println("roll back");
    }

}
