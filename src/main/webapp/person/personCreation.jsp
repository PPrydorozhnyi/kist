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
    <title>Person page</title>

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

    <form:form method="POST" action="${contextPath}/person/create" modelAttribute="personForm" class="form-signin">
        <h2 class="form-signin-heading">${personForm.id != null ? 'Edit' : 'Create'} person</h2>

        <form:hidden path="id" />

        <%--NAME--%>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Person name:
                <form:input type="text" path="name" class="form-control"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>

        <%--SURNAME--%>
        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Person surname:
                <form:input type="text" path="surname" class="form-control"/>
                <form:errors path="surname"/>
            </div>
        </spring:bind>

        <%--Address--%>
        <spring:bind path="address">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Address:
                <form:input type="text" path="address" class="form-control"/>
                <form:errors path="address"/>
            </div>
        </spring:bind>

        <%--Sex--%>
        <spring:bind path="sex">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Sex:
                <form:select path="sex" cssClass="form-control">
                    <form:options items="${sexnEnum}"/>
                </form:select>
            </div>
        </spring:bind>

        <%--Birth_date--%>
        <spring:bind path="birthDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Birth date:
                <form:input type="date" path="birthDate" class="form-control"/>
                <form:errors path="birthDate"/>
            </div>
        </spring:bind>

        <%--Birth_place--%>
        <spring:bind path="birthPlace">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Birth place:
                <form:input type="text" path="birthPlace" class="form-control" />
                <form:errors path="birthPlace"/>
            </div>
        </spring:bind>

        <%--Telephone Number--%>
        <spring:bind path="telephoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Telephone Number:
                <form:input type="text" path="telephoneNumber" class="form-control" />
                <form:errors path="telephoneNumber"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
