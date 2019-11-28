<%@ page import="com.peter.kist.model.enums.Sex" %>
<%@ page contentType="text/html;charset=utf-8" %>
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
    <title>Person page</title>

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

    <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/person/create" class="form-signin">
        <button type="submit">Create new person</button>
    </form:form>
    <hr>
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover" style="width: 80%"><caption>Person table</caption>
                <thead class="thead-dark">
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
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
