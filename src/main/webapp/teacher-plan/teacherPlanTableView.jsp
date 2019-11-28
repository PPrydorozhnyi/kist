<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teacher Plan page</title>

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
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover"> <caption>Teacher_Plan table</caption>
                <thead class="thead-dark">
                <tr>
                    <th>Tester name</th>
                    <th>Semester</th>
                    <th>Group</th>
                    <th>Test Kind</th>
                    <th>Subject</th>
                    <th>Test Date</th>
                    <th>Obligatory</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teacherPlans}" var="teacherPlan">
                    <tr>
                        <td><a href="${contextPath}/teacher-plan/${teacherPlan.id}">
                                ${"".concat(teacherPlan.tester.name).concat(" ").concat(teacherPlan.tester.surname)}</a></td>
                        <td>${teacherPlan.semester.teachBeginDate}</td>
                        <td>${teacherPlan.group.groupCode}</td>
                        <td>${teacherPlan.testKind.name}</td>
                        <td>${teacherPlan.subject.name}</td>
                        <td>${teacherPlan.testDate}</td>
                        <td>${teacherPlan.obligatory}</td>
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
