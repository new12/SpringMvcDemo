package dao;

import entity.Job;

import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */
public interface JobDao extends BaseDao<Job>{
    List<Job> findByName(String name);
}
