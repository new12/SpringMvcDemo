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


    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        if (targetDomainObject instanceof Job){
            Job target = (Job)targetDomainObject;
            Boolean x = checkJobPermission(permission, principal, target);
            if (x != null) return x;
        }
        return false;
    }

    private Boolean checkJobPermission(Object permission, UserDetails principal, Job target) {
        if (!target.getUser().getName().equals(principal.getUsername()))return  false;
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, final Serializable targetId, String targetType, Object permission) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        if (targetType.equals("entity.Job")){
            Job job = jobDao.getById(targetId);
           return  checkJobPermission(permission,principal,job);
        }
        return false;
    }
}
