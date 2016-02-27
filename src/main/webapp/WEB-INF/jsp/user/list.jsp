<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>


<a href="add">添加</a>
<br><br>

<body>
    <c:forEach items="${users}" var="user" >
        ${user.value.username}
        ----${user.value.password}
        ----<a href="${user.value.username}">${user.value.name}</a>
        ----<a href="${user.value.username}/delete">删除</a>
        <br>
    </c:forEach>
</body>
</html>
