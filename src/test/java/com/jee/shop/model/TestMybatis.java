package com.jee.shop.model;


import com.jee.shop.mapper.UserMapper;
import com.jee.shop.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZSt on 2016/2/12.
 */
public class TestMybatis {

    @Test
    public void testAdd() {
//        System.out.println("add");
//        int a = 3;
//        Assert.assertEquals(a, 3);

        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();

            User user = new User();
            user.setUsername("b");
            user.setPassword("123");
            user.setNickname("出版社");
            user.setType(0);

            session.insert(User.class.getName() + ".add", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testUpdate() {
        System.out.println("update");

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            User user = new User();
            user.setId(1);
            user.setUsername("a");
            user.setPassword("123");
            user.setType(0);
            user.setNickname("城市");

            session.update(User.class.getName() + ".update", user);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoad() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();

            User user = session.selectOne(User.class.getName() + ".load", 1);
//            User user = session.getMapper(UserMapper.class).load(1);
            System.out.println(user.getUsername());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }

    }

}
