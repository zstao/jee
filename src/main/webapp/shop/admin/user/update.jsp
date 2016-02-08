<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %>
<%@ page import="com.jee.shop.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/8
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String password = request.getParameter("password");
    String name = request.getParameter("name");

    IUserDao userDao = DAOFactory.getUserDao();
    User user = userDao.load(id);
    user.setPassword(password);
    user.setName(name);

    userDao.update(user);
    response.sendRedirect("list.jsp");
%>
</body>
</html>
