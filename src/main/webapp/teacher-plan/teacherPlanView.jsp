<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teacher Plan page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">DB Admin</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-right" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="${contextPath}/welcome">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" onclick="document.forms['logoutForm'].submit()">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div class="container margin-table-view">

    <div class="row">
        <div class="col-10">

            <form:form method="POST" action="${contextPath}/teacher-plan/edit" modelAttribute="teacherPlanForm"
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
                        <label for="name"> Tester name:<br> </label>
                        <form:input type="text" id="name" path="tester.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="tester.name"/>
                    </div>
                </spring:bind>
                <spring:bind path="tester.surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="surname"> Tester surname: </label>
                        <form:input type="text" id="surname" path="tester.surname" class="form-control"
                                    placeholder="Tester surname"
                                    readonly="true"/>
                        <form:errors path="tester.surname"/>
                    </div>
                </spring:bind>

                <spring:bind path="semester.teachBeginDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="semester"> Semester: </label>
                        <form:input type="text" id="semester" path="semester.teachBeginDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="semester.teachBeginDate"/>
                    </div>
                </spring:bind>

                <spring:bind path="group.groupCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="group"> Group: </label>
                        <form:input type="text" id="group" path="group.groupCode" class="form-control"
                                    readonly="true"/>
                        <form:errors path="group.groupCode"/>
                    </div>
                </spring:bind>

                <spring:bind path="testKind.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label for="testkind"> TestKind: </label>
                        <form:input type="text" id="testkind" path="testKind.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="testKind.name"/>
                    </div>
                </spring:bind>

                <spring:bind path="subject.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}"><label for="subject"> Subject: </label>

                        <form:input type="text" path="subject.name" id="subject" class="form-control"
                                    readonly="true"/>
                        <form:errors path="subject.name"/>
                    </div>
                </spring:bind>

                <%--testDate--%>
                <spring:bind path="testDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}"><label for="testDate"> Test
                        Date: </label>
                        <form:input type="date" id="testDate" path="testDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="testDate"/>
                    </div>
                </spring:bind>

                <%--obligatory--%>
                <spring:bind path="obligatory">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="form-check-label" for="obligatory">Obligatory </label>
                        <form:checkbox id="obligatory" path="obligatory" class="form-check-input"
                                       readonly="true" disabled="true" cssStyle="margin-left: 10px;"/>
                        <form:errors path="obligatory"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/teacher-plan/${teacherPlanForm.id}"
                       modelAttribute="teacherPlanForm"
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
