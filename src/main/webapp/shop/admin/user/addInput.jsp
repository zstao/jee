<%@ page import="com.jee.shop.util.ValidateUtil" %><%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/6
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
</head>
<body>
<jsp:include page="include.jsp" />
<form action="add.jsp" method="post">
    <table align="center" width="500" border="1">
        <tr>
            <td>用户名：</td><td><input type="text" name="username" ><%=ValidateUtil.showError(request, "username")%></td>

        </tr>
        <tr>
            <td>用户密码：</td><td><input type="password" name="password"><%=ValidateUtil.showError(request, "password")%></td>
        </tr>
        <tr>
            <td>姓名：</td><td><input type="text" name="name" ><%=ValidateUtil.showError(request, "name")%></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="添加用户">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
