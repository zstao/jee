<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user" enctype="multipart/form-data">

    用户名：<form:input path="username"/><form:errors path="username" cssClass="error"/> <br>
    密 码： <form:password path="password"/> <form:errors path="password"/> <br>
    姓名： <form:input path="name"/> <br>
    邮箱： <form:input path="email"/>  <form:errors path="email"/> <br>
    文件： <input type="file" name="attachs"/> <br>
    <input type="submit" value="添加">

</form:form>
</body>
</html>
