package com.jee.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZSt on 2016/2/4.
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");

        writer.println("/"+req.getContextPath()+"<br/>");
        writer.println(" "+req.getSession().getServletContext().getRealPath("/"));

        String username = null;
        try {
            username = req.getParameter("username");
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.println("<h3>"+username+"</h3>");
        writer.println("</body></html>");

    }
}
