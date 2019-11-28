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
    <title>Student Group Page</title>
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
    <form:form method="DELETE" action="${contextPath}/student-group/student/${studentGroupForm.student.id}/group/${studentGroupForm.group.id}"
               modelAttribute="studentGroupForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/student-group/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all student groups</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">
            <%-- student/{studentId}/group/{groupId}--%>
            <form:form cssClass="f" method="POST" action="${contextPath}/student-group/edit" modelAttribute="studentGroupForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View student group</h2>

                <form:hidden path="id"/>
                <form:hidden path="student.id"/>
                <form:hidden path="group.id"/>

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
                        Student name:<br>
                        <form:input type="text" path="student.surname" class="form-control"
                                    placeholder="Student surname"
                                    readonly="true"/>
                        <form:errors path="student.surname"/>
                    </div>
                </spring:bind>

                <spring:bind path="group.groupCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Group:<br>
                        <form:input type="text" path="group.groupCode" class="form-control"
                                    readonly="true"/>
                        <form:errors path="group.groupCode"/>
                    </div>
                </spring:bind>

                <%--puttingDate--%>
                <spring:bind path="puttingDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="puttingDate">   Putting Date: </label>
                        <form:input type="date" id = "puttingDate" path="puttingDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="puttingDate"/>
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
