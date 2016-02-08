<%@ page import="com.jee.shop.util.ValidateUtil" %>
<%@ page import="com.jee.shop.model.User" %>
<%@ page import="com.jee.shop.dao.IUserDao" %>
<%@ page import="com.jee.shop.dao.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/6
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户更新</title>
</head>
<body>
<jsp:include page="include.jsp" />
<%
    int id = Integer.parseInt(request.getParameter("id"));
    IUserDao UserDao = DAOFactory.getUserDao();
    User user = UserDao.load(id);
%>
<form action="update.jsp" method="post">
    <table align="center" width="500" border="1">
        <input type="hidden" name="id" value="<%=id%>">
        <tr>
            <td>用户名：</td><td><%=user.getUsername()%><%=ValidateUtil.showError(request, "username")%></td>

        </tr>
        <tr>
            <td>用户密码：</td><td><input type="password" name="password" value="<%= user.getPassword()%>"><%=ValidateUtil.showError(request, "password")%></td>
        </tr>
        <tr>
            <td>姓名：</td><td><input type="text" name="name" value="<%= user.getName()%>"><%=ValidateUtil.showError(request, "name")%></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="更新用户">&nbsp;<input type="reset" value="重置">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
