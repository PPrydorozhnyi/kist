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
    <title>Teacher Plan page</title>
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

    <div class="row">
        <div class="col-10">

            <form:form cssClass="f" method="POST" action="${contextPath}/teacher-plan/edit" modelAttribute="teacherPlanForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View TeacherPlan</h2>

                <form:hidden path="id"/>
                <form:hidden path="tester.id"/>
                <form:hidden path="semester.id"/>
                <form:hidden path="group.id"/>
                <form:hidden path="testKind.id"/>
                <form:hidden path="subject.id"/>

                <spring:bind path="tester.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="name">   Tester name:<br> </label>
                        <form:input type="text" id="name" path="tester.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="tester.name"/>
                    </div>
                </spring:bind>
                <spring:bind path="tester.surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="surname">   Tester surname: </label>
                        <form:input type="text" id ="surname" path="tester.surname" class="form-control"
                                    placeholder="Tester surname"
                                    readonly="true"/>
                        <form:errors path="tester.surname"/>
                    </div>
                </spring:bind>

                <spring:bind path="semester.teachBeginDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="semester">   Semester: </label>
                        <form:input type="text" id = "semester" path="semester.teachBeginDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="semester.teachBeginDate"/>
                    </div>
                </spring:bind>

                <spring:bind path="group.groupCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="group">   Group: </label>
                        <form:input type="text" id ="group" path="group.groupCode" class="form-control"
                                    readonly="true"/>
                        <form:errors path="group.groupCode"/>
                    </div>
                </spring:bind>

                <spring:bind path="testKind.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="testkind">   TestKind: </label>
                        <form:input type="text" id = "testkind" path="testKind.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="testKind.name"/>
                    </div>
                </spring:bind>

                <spring:bind path="subject.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}"><label for="subject">   Subject: </label>

                        <form:input type="text" path="subject.name" id = "subject" class="form-control"
                                    readonly="true"/>
                        <form:errors path="subject.name"/>
                    </div>
                </spring:bind>

                <%--testDate--%>
                <spring:bind path="testDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="testDate">   Test Date: </label>
                        <form:input type="date" id = "testDate" path="testDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="testDate"/>
                    </div>
                </spring:bind>

                <%--obligatory--%>
                <spring:bind path="obligatory">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="obligatory">   Obligatory: </label>
                        <form:checkbox id = "obligatory" path="obligatory" class=""
                                    readonly="true"/>
                        <form:errors path="obligatory"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/teacher-plan/${teacherPlanForm.id}" modelAttribute="teacherPlanForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/teacher-plan/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all teacher plans</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
