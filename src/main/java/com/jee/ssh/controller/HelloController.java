package com.jee.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZSt on 2016/2/27.
 */

@Controller
public class HelloController {

    @RequestMapping({"/hello", "/"})
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
