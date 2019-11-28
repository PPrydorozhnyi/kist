<%@ page import="com.peter.kist.model.enums.Sex" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% pageContext.setAttribute("sexnEnum", Sex.values()); %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student page</title>

    <link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/table.css" rel="stylesheet">
</head>

<body>
<div class = "mainmenu">
    <ul class = "list">
        <li><a class="link" href="${contextPath}/welcome">Home page</a></li>
        <li><a class="link" href="${contextPath}/queryY">Query</a></li>
        <li><form id="logoutForm" class="link" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <a class="link" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </form></li>
    </ul>
</div>
<div class="container">
    <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/student/create" class="form-signin">
        <button class="btn btn btn-success" type="submit">Create new student</button>
    </form:form>
    <hr>
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover" style="width: 80%" ><caption>Student table</caption>
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Address</th>
                    <th>Sex</th>
                    <th>Birth date</th>
                    <th>Birth place</th>
                    <th>Telephone number</th>
                    <th>Book number</th>
                    <th>Note</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><a href="${contextPath}/student/${student.id}">${student.name}</a></td>
                        <td>${student.surname}</td>
                        <td>${student.address}</td>
                        <td>${student.sex}</td>
                        <td>${student.birthDate}</td>
                        <td>${student.birthPlace}</td>
                        <td>${student.telephoneNumber}</td>
                        <td>${student.bookNumber}</td>
                        <td>${student.note}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
