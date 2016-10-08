package test.lky.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.lky.mapper.UserMapper;
import test.lky.model.User;

import javax.annotation.Resource;

/**
 * Created by kylong on 2016/10/6.
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getUser(Integer userId){
        return  userMapper.getUser(userId);
    }
}
