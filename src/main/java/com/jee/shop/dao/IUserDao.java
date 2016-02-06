package com.jee.shop.dao;

import com.jee.shop.model.User;

import java.util.List;

/**
 * Created by ZSt on 2016/2/6.
 */
public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public List<User> list();
    public User login(String username, String password);
}
