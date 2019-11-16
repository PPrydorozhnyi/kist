<%@ page import="com.peter.kist.model.Sex" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% pageContext.setAttribute("sexnEnum", Sex.values()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Semester page</title>

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
                    <th>teachBeginDate</th>
                    <th>teachEndDate</th>
                    <th>sessionBeginDate</th>
                    <th>sessionEndDate</th>
                    <th>attest1Date</th>
                    <th>attest2Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${semesters}" var="semester">
                    <tr>
                        <td><a href="${contextPath}/semester/${semester.id}">${semester.teachBeginDate}</a></td>
                        <td>${semester.teachEndDate}</td>
                        <td>${semester.sessionBeginDate}</td>
                        <td>${semester.sessionEndDate}</td>
                        <td>${semester.attest1Date}</td>
                        <td>${semester.attest2Date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/semester/create" class="form-signin">
            <button class="btn btn btn-success" type="submit">Create</button>
        </form:form>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
