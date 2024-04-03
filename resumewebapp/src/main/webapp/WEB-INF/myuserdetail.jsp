<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: asgar
  Date: 25/12/2023
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ResumeWebApp-JDBC</title>
    <style>
        .navbar-brand:hover {
            opacity: 0.6;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


</head>
<body>
<%
    User u = (User) request.getAttribute("user");
%>
<div class="container-fluid rounded bg-white mx-auto  ">

    <%--<input type="hidden" name="action" value="update"/>--%>
    <%--<input class="w-100 btn btn-danger profile-button" type="submit" name="action" value="back">--%>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-success p-1">
            <div class="container-fluid">
                <a class="navbar-brand" href="">
                    <form action="myuserdetail" method="POST">
                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                        <button class="btn btn-info" type="submit" formaction="myuserdetail?action=back" value="back">
                            Home
                        </button>
                    </form>
                    <%--
                        <button class="btn btn-danger ml-2" type="submit"
                         formaction="logout"value="logout"> logout </button>
                     --%>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class=" collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav ms-auto ">
                        <li class="nav-item">
                            <a class="nav-link mx-2" href="#">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mx-2" href="#">Pricing</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                               role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Company
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Blog</a></li>
                                <li><a class="dropdown-item" href="#">About Us</a></li>
                                <li><a class="dropdown-item" href="#">Contact us</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="navbar-nav ms-auto d-none d-lg-inline-flex">
                        <li class="nav-item mx-2">
                            <a class="nav-link text-dark h5" href="" target="blank"><i
                                    class="fab fa-google-plus-square"></i></a>
                        </li>
                        <li class="nav-item mx-2">
                            <a class="nav-link text-dark h5" href="" target="blank"><i
                                    class="fab fa-twitter"></i></a>
                        </li>
                        <li class="nav-item mx-2">
                            <a class="nav-link text-dark h5" href="" target="blank"><i
                                    class="fab fa-facebook-square"></i></a>
                        </li>
                    </ul>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                        Launch demo modal
                    </button>
                </div>
            </div>
        </nav>
    </div>
    <form action="myuserdetail" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-3">
                    <img class="rounded-circle mt-5" width="150px"
                         src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                    <span class="font-weight-bold">Name / Surname</span><span class="text-black-50">Email</span>
                </div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-1">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label>
                            <input id="inputName" type="text" class="form-control" placeholder="firstname" name="name"
                                   value="<%=u.getName()%>">
                        </div>
                        <div class="col-md-6"><label class="labels">Surname</label>
                            <input type="text" class="form-control" placeholder="surname" name="surname"
                                   value="<%=u.getSurname()%>"></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Mobile Number</label>
                            <input type="tel" class="form-control" placeholder="enter phone number" value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Address </label>
                            <input type="text" class="form-control" placeholder="enter address infromation" value="">
                        </div>

                        <div class="col-md-12">
                            <label class="labels">BirthDate</label>
                            <input type="date" min="1990-01-01" class="form-control" placeholder="enter address line 2"
                                   value="">
                        </div>
                        <div class="col-md-12"><label class="labels">Email</label>
                            <input type="text" class="form-control" placeholder="enter email" value="">
                        </div>

                    </div>
                    <div class="row mt-4">
                        <div class="col-md-6  ">
                            <label class="labels">BirthPlace</label>
                            <select class="form-select form-control">
                                <option selected>Select Birthplace</option>
                                <option value="1">AZE</option>
                                <option value="2">TUR</option>
                                <option value="3">RUS</option>
                            </select>
                        </div>
                        <div class="col-md-6"><label class="labels">Nationality</label>
                            <select class="form-select form-control">
                                <option selected>Select Nationality</option>
                                <option value="1">AZE</option>
                                <option value="2">TUR</option>
                                <option value="3">RUS</option>
                            </select>
                        </div>


                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3 py-2">
                    <div class="col-md-12"><label class="labels">Profile Description</label>
                        <textarea name="profiledescription" rows="7" cols="50" class="form-control"
                                  placeholder="enter profile descripton" value="">
                    </textarea>
                    </div>
                    <div class="mt-5  ">
                        <input class="w-100 btn btn-primary profile-button" type="submit" name="action" value="update">
                    </div>

                </div>
            </div>
        </div>
    </form>
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
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form action="logout" method="POST">
                    <button type="submit" class="btn btn-danger">Log out</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
