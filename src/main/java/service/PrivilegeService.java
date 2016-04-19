package service;

import entity.Privilege;

/**
 * Created by kylong on 2016/4/19.
 */
public interface PrivilegeService extends BaseService<Privilege> {
    public void save(Integer domainId, Privilege e);
}
