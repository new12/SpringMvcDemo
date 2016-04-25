package dao.Impl;

import dao.BaseDao;
import dao.JobDao;
import entity.Job;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */
@Repository
public class JobDaoImpl extends BaseDaoImpl<Job> implements JobDao {
    public JobDaoImpl() {
        super(Job.class);
    }

    @Override
    public List<Job> findByName(String name) {
        Query query = getSession().createQuery("from Job j where j.name = :name");
        query.setParameter("name",name);
        return query.list();
    }
}
