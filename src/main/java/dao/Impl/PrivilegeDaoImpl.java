package dao.Impl;

import dao.PrivilegeDao;
import entity.Privilege;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege,Integer> implements PrivilegeDao{
    public PrivilegeDaoImpl() {
        super(Privilege.class);
    }
}
