package com.jee.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZSt on 2016/2/27.
 */

@Controller
public class HelloController {

    @RequestMapping({"/hello", "/"})
    public String hello(String username, Model model){
        model.addAttribute("username", username);
        System.out.println("hello " + username);
        return "hello";
    }
}
