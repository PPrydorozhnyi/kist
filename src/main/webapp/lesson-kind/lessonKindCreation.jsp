<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Lesson Kind page</title>

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

    <form:form method="POST" action="${contextPath}/lesson-kind/create" modelAttribute="lessonKindForm" class="form-signin">
        <h2 class="form-signin-heading">${lessonKindForm.id != null ? 'Edit' : 'Create'} lessonKind</h2>

        <form:hidden path="id" />

        <%--lessonKind_name--%>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">  LessonKind name:
                <form:input type="text" path="name" class="form-control"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
