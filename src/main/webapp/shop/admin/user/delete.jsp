<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    IUserDao userDao = DAOFactory.getUserDao();
    userDao.delete(id);
    response.sendRedirect("list.jsp");
//    return;
%>

