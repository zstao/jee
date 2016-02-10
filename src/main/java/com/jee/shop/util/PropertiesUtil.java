package com.jee.shop.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZSt on 2016/2/11.
 */
public class PropertiesUtil {
    private static Properties jdbcProp;

    public static Properties getJdbcProp(){
        try {
            if(jdbcProp==null){
                jdbcProp = new Properties();
                jdbcProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  jdbcProp;
    }
}
