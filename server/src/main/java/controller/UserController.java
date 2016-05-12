package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.List;

/**
 * Created by kylong on 2016/4/20.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        return  userService.findAll();
    }
    @RequestMapping(value="/user/{name}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String name){
        return  userService.findByName(name);
    }
}
