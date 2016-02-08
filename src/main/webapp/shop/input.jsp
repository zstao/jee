<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %>
<%@ page import="com.jee.shop.model.User" %>
<%@ page import="com.jee.shop.model.ShopException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        IUserDao userDao = DAOFactory.getUserDao();
        User user = userDao.login(username, password);

        session.setAttribute("loginUser", user);
        response.sendRedirect(request.getContextPath()+"/shop/admin/user/list.jsp");

    } catch (ShopException e) {
%>
    <h4><%=e.getMessage()%></h4>
<%
        e.printStackTrace();
    }

%>
</body>
</html>
