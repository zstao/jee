package com.jee.ssh.controller;

import com.jee.ssh.model.User;
import com.jee.ssh.model.UserException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public String add(@Validated User user, BindingResult result, @RequestParam("attachs") MultipartFile[] attachs, HttpServletRequest httpServletRequest) throws IOException {
        if(result.hasErrors()){
            return "user/add";
        }
//        System.out.println(attach.getName()+","+attach.getOriginalFilename());
        String realpath = httpServletRequest.getSession().getServletContext().getRealPath("/resources/upload");
//        realpath = "D:\\JetBrains_Workspace\\IdeaProjects\\JEE\\src\\main\\webapp\\resources\\upload";
        System.out.println(realpath);
        for(MultipartFile attach : attachs){
            if(attach.isEmpty()) continue;
            File f = new File(realpath+"/"+attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
        }
        users.put(user.getUsername(), user);
        return "redirect:/user/users";
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String show(@PathVariable String username, Model model){
        model.addAttribute(users.get(username));
        return "user/show";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String username){
        return users.get(username);
    }


    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable String username){
        users.remove(username);
        return "redirect:/user/users";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session){
        if(!users.containsKey(username)) {
            throw new UserException("用户名不存在");
        }
        if(!users.get(username).getPassword().equals(password)){
            throw new UserException("密码不正确");
        }
        session.setAttribute("loginUser", users.get(username));
        return "redirect:/user/users";
    }
}
