package service.impl;

import dao.JobDao;
import entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import service.JobService;

import javax.transaction.TransactionManager;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by kylong on 2016/4/25.
 */
@Service
public class PermissionEvaluatorService implements PermissionEvaluator {
    @Autowired
    private JobDao jobDao;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public void  setTransactionTemplate(PlatformTransactionManager tx){
        this.transactionTemplate = new TransactionTemplate(tx);
    };

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        if (targetDomainObject instanceof Job){
            Job target = (Job)targetDomainObject;
            if (!target.getUser().getName().equals(principal.getUsername()))return  false;
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            for (GrantedAuthority auth : authorities) {
                if (auth.getAuthority().equals(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
//        UserDetails principal = (UserDetails) authentication.getPrincipal();
//        if (targetType.equals("entity.Job")){
//            Job targe = null;
//            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//                @Override
//                protected void doInTransactionWithoutResult(TransactionStatus status) {
//                    Job target = jobService.getById(targetId);
//                }
//            });
//            if (!target.getUser().equals(principal.getUsername()))return  false;
//            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
//            for (GrantedAuthority auth : authorities) {
//                if (auth.getAuthority().equals(permission)) {
//                    return true;
//                }
//            }
//        }
        return false;
    }
}
