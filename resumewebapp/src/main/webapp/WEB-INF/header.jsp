<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: asgar
  Date: 09/01/2024
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%= "Welcome, " + user.getName() + " !-!" %>
