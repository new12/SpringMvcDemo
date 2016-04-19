package service.impl;

import dao.BaseDao;
import dao.PrivilegeDao;
import entity.Domain;
import entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.DomainService;
import service.PrivilegeService;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends  BaseServiceImpl<Privilege> implements PrivilegeService{

    @Autowired
    private DomainService domainService;

    private PrivilegeDao dao;
    @Autowired
    public PrivilegeServiceImpl(PrivilegeDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void save(Privilege entity) {
        throw  new UnsupportedOperationException();
    }


    @Override
    public void save(Integer domainId, Privilege e) {
        Domain domain = domainService.getById(domainId);
        if (domain == null) throw  new RuntimeException("domain is null");
        e.setDomain(domain);
        dao.save(e);
    }
}
