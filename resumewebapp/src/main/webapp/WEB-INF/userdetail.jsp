<%-- JSP Comments
    Document   : user
    Created on : 4 Dec 2023, 00:16:02
    Author     : asgar
--%>

<%@page import="com.company.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- Yuxaridaki hisse Tomcat-e lazim olan hissedir. --%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<%--View --%>
<%
    User u = (User) request.getAttribute("user");
%>


<div>
    <form action="userdetail" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <input type="hidden" name="action" value="update"/>

        <label for="inputName">name:</label>
        <input id="inputName" name="name" value="<%=u.getName()%>"/>
        <br/><br>
        <label for="inputSurname">surname:</label>
        <input id="inputSurname" name="surname" value="<%=u.getSurname()%>"/>

        <input type="submit" name="save" value="Save"/>
    </form>
</div>


</body>
</html>