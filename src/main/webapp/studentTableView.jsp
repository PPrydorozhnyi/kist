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
    <title>Student page</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover">
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
        <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/student/create" class="form-signin">
            <button class="btn btn btn-success" type="submit">Create</button>
        </form:form>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
