<%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/5
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form>
    <input type="text" name="username">
    <input type="submit" value="提交">
</form>

<%
    String username = "";
    out.println(username + "hello");
    username = request.getParameter("username");

%>
<br>
<%= username %>

<br>
<%= application.getRealPath("/") %>

<br>
<%!
   public int add(int a, int b){
       return a+b;
   }
%>
<%= add(1, 2)%>

</body>
</html>
