package service.impl;

import dao.BaseDao;
import dao.RoleDao;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.BaseService;
import service.RoleService;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    private RoleDao dao;
    @Autowired
    public RoleServiceImpl(RoleDao dao) {
        super(dao);
        this.dao = dao;
    }
}
