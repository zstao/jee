<%--
  Created by IntelliJ IDEA.
  User: ZSt
  Date: 2016/2/5
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>包含</title>
</head>
<body>

<%--动态包含--%>
<%@include file="public/top.jsp"%>

<%--静态包含--%>
<jsp:include page="public/bottom.jsp"></jsp:include>
</body>
</html>
