package com.jee.shop.model;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZSt on 2016/2/12.
 */
public class TestFirstMybatis {

    public static void main(String[] args) {
        testUpdate();
    }

    public static void testInsert(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            User user = new User();
            user.setUsername("a");
            user.setPassword("123");
            user.setType(0);
            user.setNickname("城市");

            session.insert("com.jee.shop.model.User.add", user);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testUpdate(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            User user = new User();
            user.setId(1);
            user.setUsername("a");
            user.setPassword("123");
            user.setType(0);
            user.setNickname("城市123");

            session.update("com.jee.shop.model.User.update", user);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
