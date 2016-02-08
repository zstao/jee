<%@ page import="com.jee.shop.model.User" %>
<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %>
<%@ page import="com.jee.shop.model.ShopException" %>
<%@ page import="com.jee.shop.util.ValidateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String name = request.getParameter("name");

    boolean validate = ValidateUtil.validateNull(request, new String[] {"username", "password", "name"});
    if(!validate){
%>
    <jsp:forward page="addInput.jsp" />
<%
    }

    User u = new User(username, password, name);
    IUserDao userDao = DAOFactory.getUserDao();

    try {
        userDao.add(u);
        response.sendRedirect("list.jsp");
//        return;
%>
    添加用户成功! <a href="addInput.jsp">添加用户</a>&nbsp;<a href="list.jsp">用户列表</a>
<%

    } catch (ShopException e) {
%>
    <h2>发生错误：<%=e.getMessage()%></h2>
<%
    }
%>

