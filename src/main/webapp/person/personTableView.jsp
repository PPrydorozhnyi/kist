<%@ page import="com.peter.kist.model.enums.Sex" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% pageContext.setAttribute("sexnEnum", Sex.values()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Person page</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        @media only screen and (min-width: 768px) {
            .dropdown:hover .dropdown-menu {
                display: block;
                margin-top: 0;
            }
        }
    </style>

</head>

<body>

<nav id="myNAV" class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="#">Welcome ${pageContext.request.userPrincipal.name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/welcome">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Tables
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${contextPath}/person/all">Person</a>
                    <a class="dropdown-item" href="${contextPath}/student/all">Student</a>
                    <a class="dropdown-item" href="${contextPath}/group/all">Group</a>
                    <a class="dropdown-item" href="${contextPath}/mark/all">Mark</a>
                    <a class="dropdown-item" href="${contextPath}/violation/all">Violation</a>
                    <a class="dropdown-item" href="${contextPath}/order/all">Orders</a>
                    <a class="dropdown-item" href="${contextPath}/violation-kind/all">Violation kind</a>
                    <a class="dropdown-item" href="${contextPath}/punish-kind/all">Punish kind</a>
                    <a class="dropdown-item" href="${contextPath}/order-kind/all">Order kind</a>
                    <a class="dropdown-item" href="${contextPath}/student-group/all">Student groups</a>
                    <a class="dropdown-item" href="${contextPath}/student-mark/all">Student marks</a>

                </div>
            </li>
        </ul>
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </form>
    </div>
    <!--/.nav-collapse -->
</nav>

<div class="container mt-5">
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Address</th>
                    <th>Sex</th>
                    <th>Birth date</th>
                    <th>Birth place</th>
                    <th>Telephone number</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${person}" var="person">
                    <tr>
                        <td><a href="${contextPath}/person/${person.id}">${person.name}</a></td>
                        <td>${person.surname}</td>
                        <td>${person.address}</td>
                        <td>${person.sex}</td>
                        <td>${person.birthDate}</td>
                        <td>${person.birthPlace}</td>
                        <td>${person.telephoneNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/person/create" class="form-signin">
            <button class="btn btn btn-success" type="submit">Create</button>
        </form:form>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
