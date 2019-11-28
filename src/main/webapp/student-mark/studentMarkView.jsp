<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student Mark Page</title>
    <link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
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
    <form:form method="DELETE" action="${contextPath}/student-mark/student/${studentMarkForm.student.id}/teacherPlan/${studentMarkForm.teacherPlan.id}"
               modelAttribute="studentMarkForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/student-mark/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all studentMarks</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">
            <form:form cssClass="f" method="POST" action="${contextPath}/student-mark/edit" modelAttribute="studentMarkForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View student mark</h2>

                <form:hidden path="id"/>
                <form:hidden path="student.id"/>
                <form:hidden path="teacherPlan.id"/>

                <spring:bind path="student.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Student name:<br>
                        <form:input type="text" path="student.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="student.name"/>
                    </div>
                </spring:bind>
                <spring:bind path="student.surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Student surname:<br>
                        <form:input type="text" path="student.surname" class="form-control"
                                    readonly="true"/>
                        <form:errors path="student.surname"/>
                    </div>
                </spring:bind>

                <spring:bind path="teacherPlan.tester.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Tester name:<br>
                        <form:input type="text" path="teacherPlan.tester.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="teacherPlan.tester.name"/>
                    </div>
                </spring:bind>
                <spring:bind path="teacherPlan.tester.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Tester surname:<br>
                        <form:input type="text" path="teacherPlan.tester.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="teacherPlan.tester.name"/>
                    </div>
                </spring:bind>

                <spring:bind path="teacherPlan.testDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Test date:<br>
                        <form:input type="text" path="teacherPlan.testDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="teacherPlan.testDate"/>
                    </div>
                </spring:bind>

                <spring:bind path="mark.value">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Mark:<br>
                        <form:input type="text" path="mark.value" class="form-control"
                                    readonly="true"/>
                        <form:errors path="mark.value"/>
                    </div>
                </spring:bind>

                <button class="but" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
