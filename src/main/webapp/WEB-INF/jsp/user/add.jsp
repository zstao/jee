<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    用户名： <form:input path="username" /> <br>
    密 码：  <form:input path="password" /> <br>
    姓名：   <form:input path="name" /> <br>
    邮箱：   <form:input path="email" /> <br>
    <input type="submit" value="添加">
</form:form>
</body>
</html>
