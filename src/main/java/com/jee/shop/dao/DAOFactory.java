package com.jee.shop.dao;

/**
 * Created by ZSt on 2016/2/6.
 */
public class DAOFactory {
    public static IUserDao getUserDao() {
        return new UserDao();
    }
}
