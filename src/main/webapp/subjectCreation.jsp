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
    <title>Subject page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/subject/create" modelAttribute="subjectForm" class="form-signin">
        <h2 class="form-signin-heading">${subjectForm.id != null ? 'Edit' : 'Create'} subject</h2>

        <form:hidden path="id" />

        <%--subject_name--%>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Subject name"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>

        <%--subject_shifr--%>
        <spring:bind path="code">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="code" class="form-control" placeholder="Subject shifr"/>
                <form:errors path="code"/>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
