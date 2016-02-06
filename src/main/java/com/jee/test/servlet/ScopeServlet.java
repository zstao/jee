package com.jee.test.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZSt on 2016/2/5.
 */
public class ScopeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init servlet");
    }

    /**
     * 两个init同时存在时，调用这个
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        String username = config.getInitParameter("username");
        System.out.println(username);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service is invoked");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }
}
