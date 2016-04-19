package service.impl;

import dao.BaseDao;
import dao.PrivilegeDao;
import entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PrivilegeService;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends  BaseServiceImpl<Privilege> implements PrivilegeService{

    private PrivilegeDao dao;
    @Autowired
    public PrivilegeServiceImpl(PrivilegeDao dao) {
        super(dao);
        this.dao = dao;
    }
}
