<%-- JSP Comments
    Document   : user
    Created on : 4 Dec 2023, 00:16:02
    Author     : asgar
--%>

<%@page import="com.company.entity.User" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

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

    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>

</head>
<body>
<%
    @SuppressWarnings("unchecked")
    List<User> list = (List<User>) request.getAttribute("list");
   // User user = (User) session.getAttribute("loggedInUser");
%>
<%--<jsp:include page="header.jsp"/>--%>
<br>
<br>
<div class="container mycontainer">
    <div class=" col-12">
        <div class="col-4">
            <form action="usersJ.jsp" method="GET">
                <div class="form-group">
                    <%--<input type="hidden" name="nid" value="1"/>--%>
                    <label for="nameInput">name:</label>
                    <input id="nameInput" class="form-control" name="name" value=""/>
                </div>

                <div class="form-group">
                    <label for="surnameInput">surname:</label>
                    <input id="surnameInput" class="form-control" name="surname" value=""/>
                </div>
                <button class="btn btn-primary" name="search" type="submit" value="Search">Search</button>
                <%--<input class="btn btn-primary" type="submit" name="search" value="Search"/>--%>
            </form>
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
                <%
                    for (User u : list) {
                %>
                <tr>
                    <td><%= u.getName()%>
                    </td>
                    <td><%= u.getSurname()%>
                    </td>
                    <td><%= u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%>
                    </td>
                    <td style="width: 7px;">
                        <%--<form action="userdetail" method="POST">--%>
                        <%--<input type="hidden" name="id" value="<%=u.getId()%>">--%>
                        <%--<input type="hidden" name="action" value="delete">--%>
                        <button class="btn btn-danger" value="delete"
                                data-toggle="modal" data-target="#exampleModal"
                                onclick="setIdForDelete('<%=u.getId()%>')">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                        <%--</form>--%>
                    </td>
                    <td style="width:7px;">
                        <form action="myuserdetail" method="GET">
                            <input type="hidden" name="id" value="<%= u.getId() %>">
                            <input type="hidden" name="action" value="update">
                            <button class="btn btn-warning" value="update">
                                <i class="fas fa-pen-square"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%>
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
