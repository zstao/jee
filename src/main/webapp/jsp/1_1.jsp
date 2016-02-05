<%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/5
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    response.sendRedirect("1.jsp");

    System.out.println("1.jsp");  //仍会执行
%>

</body>
</html>
