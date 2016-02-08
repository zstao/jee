<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %>
<%@ page import="com.jee.shop.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/7
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    IUserDao userDao = DAOFactory.getUserDao();
    List<User> users = userDao.list();
%>
<body>
<jsp:include page="include.jsp" />
<table align="center" border="1" width="600">
    <tr>
        <td>id</td><td>用户名</td><td>密码</td><td>姓名</td><td>操作</td>
    </tr>

    <%
        for(User user:users){
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getName()%></td>
        <td><a href="delete.jsp?id=<%=user.getId()%>">删除</a>&nbsp;<a href="updateInput.jsp?id=<%=user.getId()%>">更新</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
