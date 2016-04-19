package service.impl;

import dao.DomainDao;
import entity.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.DomainService;

/**
 * Created by kylong on 2016/4/19.
 */
@Service
@Transactional
public class DomainServiceImpl extends BaseServiceImpl<Domain> implements DomainService {
    private DomainDao dao;
    @Autowired
    public DomainServiceImpl(DomainDao dao) {
        super(dao);
        this.dao = dao;
    }
}
