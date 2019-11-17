<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="teachers" value="${pageContext.request.getAttribute('teachers')}"/>
<c:set var="lessonKinds" value="${pageContext.request.getAttribute('lessonKinds')}"/>

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

        <form:hidden path="id"/>

        <%--lesson_name--%>
        <spring:bind path="teacherId">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Lesson teacher:
                <form:select path="teacherId">

                    <c:forEach items="${teachers}" var="teacher">
                        <%--                        <% System.out.println("teacherId: " + pageContext.findAttribute("lessonForm.teacherId") +--%>
                        <%--                        " currentTeacherId: " + pageContext.findAttribute("teacher.id")); %>--%>
                        <option ${teacher.id == lessonForm.teacherId ? 'selected="selected"' : ''}
                                value="${teacher.id}">${teacher.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="teacherId"/>
            </div>
        </spring:bind>

        <%--Integer--%>
        <spring:bind path="lessonKindId">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Lesson Kind:
                <form:select path="lessonKindId">
                    <c:forEach items="${lessonKinds}" var="lessonKind">
                        <option ${lessonKind.id == lessonForm.lessonKindId ? 'selected="selected"' : ''}
                                value="${lessonKind.id}">${lessonKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="lessonKindId"/>
            </div>
        </spring:bind>

        <%--lesson_name--%>
        <spring:bind path="hours">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Lesson hours:
                <form:input type="text" path="hours" class="form-control"
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
