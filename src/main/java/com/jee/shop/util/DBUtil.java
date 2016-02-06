package com.jee.shop.util;

import java.sql.*;

/**
 * Created by ZSt on 2016/2/6.
 */
public class DBUtil {
    public static Connection getConnection(){
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jee_shop";
        String driver = "com.mysql.jdbc.Driver";

        Connection con = null;
        try {
            Class.forName(driver); //指定连接类型
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con){
        if(con!=null) try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps){
        if(ps!=null) try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        if(rs!=null) try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
