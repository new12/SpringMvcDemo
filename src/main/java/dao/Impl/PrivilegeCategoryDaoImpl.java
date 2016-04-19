package dao.Impl;

import dao.PrivilegeCategoryDao;
import entity.PrivilegeCategory;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class PrivilegeCategoryDaoImpl extends BaseDaoImpl<PrivilegeCategory> implements PrivilegeCategoryDao{
    public PrivilegeCategoryDaoImpl() {
        super(PrivilegeCategory.class);
    }
}
