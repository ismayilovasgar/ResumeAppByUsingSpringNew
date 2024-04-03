<%--
  Created by IntelliJ IDEA.
  User: asgar
  Date: 10/12/2023
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Why are you here ?</title>
</head>
<body>
<center style="font-size:20px;color: red; text-decoration:underline  ">
    <%= request.getParameter("msg") %>
</center>
</body>
</html>
