package com.jee.shop.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZSt on 2016/2/10.
 */
public class TestProp {
    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            properties.load(TestProp.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String username = properties.getProperty("username");
            System.out.println(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
