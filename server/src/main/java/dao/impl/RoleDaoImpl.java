package dao.impl;

import dao.RoleDao;
import entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
//@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }
}
