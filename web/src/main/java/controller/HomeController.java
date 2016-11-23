package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.didichuxing.framework.base.AbstractController;

import model.User;

@Controller
public class HomeController extends AbstractController{
	public Object getUser(@ModelAttribute User user){
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		return null;
	}
}
