<%-- JSP Comments
    Document   : user
    Created on : 4 Dec 2023, 00:16:02
    Author     : asgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users List </title>
    <%--<script type="text/javascript" src="assets/js/users.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<style>
    .error {
        color: red;
    }
</style>
<br>
<br>
<div class="container ">
    <div class=" col-12">
        <div class="col-4">
            <form:form action="usersm" method="GET" modelAttribute="user">

                <div class="form-group">
                    <label for="name">name:</label>
                    <form:input
                            class="form-control"
                            path="name"/>
                    <f:errors path="name" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="surname">surname:</label>
                    <form:input
                            class="form-control"
                            path="surname"/>
                    <form:errors path="surname" cssClass="error"/>

                </div>
                <form:button class="btn btn-primary" name="search" type="submit" value="">
                    Search
                </form:button>
            </form:form>
        </div>
        <br>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>National</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%--for(User u :users ){}--%>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.name}</td>
                        <td><c:out value="${u.surname}"/></td>
                        <td><c:out value="${u.nationality.name}"/></td>
                        <td style="width: 7px;">
                                <%--<form action="userdetail" method="POST">--%>
                                <%--<input type="hidden" name="id" value="<%=u.getId()%>">--%>
                                <%--<input type="hidden" name="action" value="delete">--%>
                            <button class="btn btn-danger" value="delete"
                                    data-toggle="modal" data-target="#exampleModal"
                                    onclick="setIdForDelete('${ u.id}')">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                                <%--</form>--%>
                        </td>
                        <td style="width:7px;">
                            <form action="myuserdetail" method="GET">
                                <input type="hidden" name="id" value="${u.id}">
                                <input type="hidden" name="action" value="update">
                                <button class="btn btn-warning" value="update">
                                    <i class="fas fa-pen-square"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure ?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</div>

</body>

</html>
