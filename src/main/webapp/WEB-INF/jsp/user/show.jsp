<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>用户名：</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>密 码：</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>邮箱：</td>
        <td>${user.email}</td>
    </tr>
</table>

</body>
</html>
