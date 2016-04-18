package dao.Impl;

import dao.RoleDao;
import entity.Role;

/**
 * Created by kylong on 2016/4/18.
 */
public class RoleDaoImpl extends CrudDaoImpl<Role,Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }
}
