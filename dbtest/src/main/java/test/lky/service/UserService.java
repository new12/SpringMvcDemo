package test.lky.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserMapper userMapper;

    public User get(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }

}
