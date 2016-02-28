package com.jee.ssh.service;

import com.jee.ssh.dao.IUserDao;
import com.jee.ssh.model.Pager;
import com.jee.ssh.model.User;
import com.jee.ssh.model.UserException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZSt on 2016/2/28.
 */

@Service("userService")
public class UserService implements IUserService {

    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    public void add(User user) {
        User u = userDao.loadByUsername(user.getUsername());
        if(u!=null) throw new UserException("添加的用户已经存在");
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public List list() {
        return userDao.list();
    }

    @Override
    public Pager<User> find() {
        return userDao.find();
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.loadByUsername(username);

        if(user==null) throw new UserException("用户不存在");
        if(!user.getPassword().equals(password)) throw new UserException("密码不正确");

        return user;
    }
}
