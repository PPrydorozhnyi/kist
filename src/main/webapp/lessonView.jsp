<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Lesson page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-10">

            <form:form method="POST" action="${contextPath}/lesson/edit" modelAttribute="lessonForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View lesson</h2>

                <form:hidden path="id"/>

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

                <%--hours--%>
                <spring:bind path="hours">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="hours" class="form-control" placeholder="Lesson hours"
                                    autofocus="true"/>
                        <form:errors path="hours"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/lesson/${lessonForm.id}" modelAttribute="lessonForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/lesson/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all lessons</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/lesson/${lessonForm.id}/groups" modelAttribute="lessonForm"
                       class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View groups for lesson</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
