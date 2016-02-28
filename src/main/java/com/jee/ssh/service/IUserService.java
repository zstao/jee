package com.jee.ssh.service;

import com.jee.ssh.model.Pager;
import com.jee.ssh.model.User;

import java.util.List;

/**
 * Created by ZSt on 2016/2/28.
 */
public interface IUserService {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public List list();
    public Pager<User> find();
    public User login(String username, String password);
}
