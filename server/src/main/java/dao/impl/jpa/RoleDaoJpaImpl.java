package dao.impl.jpa;

import dao.RoleDao;
import entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kylong on 2016/8/8.
 */
@Repository
@Transactional
public class RoleDaoJpaImpl extends BaseDaoJpaImpl<Role> implements RoleDao {
    public RoleDaoJpaImpl() {
        super(Role.class);
    }
}
