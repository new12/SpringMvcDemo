package service;

import entity.Job;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */

public interface JobService extends BaseService<Job> {
    public List<Job> findByName(String name);
}
