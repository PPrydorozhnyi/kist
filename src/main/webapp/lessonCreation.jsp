<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Lesson page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/lesson/create" modelAttribute="lessonForm" class="form-signin">
        <h2 class="form-signin-heading">${lessonForm.id != null ? 'Edit' : 'Create'} lesson</h2>

        <form:hidden path="id" />

        <%--lesson_name--%>
        <spring:bind path="teacher">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="teacher" class="form-control" placeholder="Lesson teacher"
                            autofocus="true"/>
                <form:errors path="teacher"/>
            </div>
        </spring:bind>

        <%--Integer--%>
        <spring:bind path="lessonKind">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lessonKind" class="form-control" placeholder="Lesson Kind"/>
                <form:errors path="lessonKind"/>
            </div>
        </spring:bind>

        <%--lesson_name--%>
        <spring:bind path="hours">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="hours" class="form-control" placeholder="Lesson hours"
                            autofocus="true"/>
                <form:errors path="hours"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>