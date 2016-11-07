package dao.impl.jpa;

import dao.JobDao;
import entity.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kylong on 2016/8/8.
 */
@Repository
@Transactional
public class JobDaoJpaImpl extends BaseDaoJpaImpl<Job> implements JobDao {
    public JobDaoJpaImpl(){
        super(Job.class);
    }

    @Override
    public List<Job> findByName(String name) {
        return  em.createQuery("from job j where j.name=:name").setParameter("name",name).getResultList();
    }
}
