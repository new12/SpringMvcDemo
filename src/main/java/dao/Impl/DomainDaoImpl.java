package dao.Impl;

import dao.DomainDao;
import entity.Domain;
import org.springframework.stereotype.Repository;

/**
 * Created by kylong on 2016/4/18.
 */
@Repository
public class DomainDaoImpl extends BaseDaoImpl<Domain> implements DomainDao {
    public DomainDaoImpl() {
        super(Domain.class);
    }
}
