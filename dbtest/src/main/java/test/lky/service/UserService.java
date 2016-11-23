package test.lky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.lky.listener.ExceptionEvent;
import test.lky.mapper.UserMapper;
import test.lky.model.User;

/**
 * Created by kylong on 2016/10/6.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApplicationEventPublisher publisher;

    public User get(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int insert(User user) {
        int i = userMapper.insert(user);
        this.publisher.publishEvent(new ExceptionEvent());
        return i;
    }

}
