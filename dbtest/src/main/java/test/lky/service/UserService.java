package test.lky.service;

import test.lky.model.User;

/**
 * Created by longkeyu on 2016/12/30.
 */
public interface UserService {
    User get(Integer userId);
    int insert(User user);
    int delete(Integer i);
}
