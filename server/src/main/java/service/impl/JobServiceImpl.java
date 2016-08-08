package service.impl;

import dao.JobDao;
import entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.JobService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */
@Service
@Transactional
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService {
    @Autowired
    private JobDao jobDao;
    @Autowired
    public JobServiceImpl( JobDao jobDao) {
        super(jobDao);
        this.jobDao = jobDao;
    }

    @Override
    @PreAuthorize("hasPermission(#id,'entity.Job','')")
    public Job getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @PostFilter("hasPermission(filterObject,'')")
    public List<Job> findByName(String name) {
        return jobDao.findByName(name);
    }


}
