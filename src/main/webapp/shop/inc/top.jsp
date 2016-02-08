<%@ page import="com.jee.shop.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("loginUser");
%>
<div style="text-align: right">
    欢迎[<%=user.getUsername()%>]!
    <a href="<%=request.getContextPath()+"/shop/logout.jsp"%>">退出</a>
</div>
