package com.jee.ssh.controller;

import com.jee.ssh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZSt on 2016/2/27.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        users.put("aaa", new User("aaa", "cscd", "csc", "cscs"));
        users.put("bbb", new User("bbb", "cscd", "csc", "cscs"));
        users.put("ccc", new User("ccc", "cscd", "csc", "cscs"));
        users.put("ddd", new User("ddd", "cscd", "csc", "cscs"));
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", users);
        return "user/list";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user){
        users.put(user.getUsername(), user);
        System.out.println("redirect: /");
        return "redirect:/user/users";
    }
}
