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

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/lesson/create" modelAttribute="lessonForm" class="form-signin">
        <h2 class="form-signin-heading">${lessonForm.id != null ? 'Edit' : 'Create'} lesson</h2>

        <form:hidden path="id"/>

        <%--lesson_name--%>
        <spring:bind path="teacher.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="teach_name">   Lesson teacher: </label>
                <form:select id = "teach_name" path="teacher.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${teachers}" var="teacher">
                        <option ${teacher.id == lessonForm.teacher.id ? 'selected="selected"' : ''}
                                value="${teacher.id}">${"".concat(teacher.name).concat(" ").concat(teacher.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="teacher.id"/>
            </div>
        </spring:bind>

        <%--Lesson Kind--%>
        <spring:bind path="lessonKind.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="kind_name">   Lesson Kind: </label>
                <form:select path="lessonKind.id" id = "kind_name" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${lessonKinds}" var="lessonKind">
                        <option ${lessonKind.id == lessonForm.lessonKind.id ? 'selected="selected"' : ''}
                                value="${lessonKind.id}">${lessonKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="lessonKind.id"/>
            </div>
        </spring:bind>

        <%--lesson_name--%>
        <spring:bind path="hours">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="lesson_hours">   Lesson hours: </label>
                <form:input type="text" id = "lesson_hours" path="hours" class="form-control"
                            autofocus="true"/>
                <form:errors path="hours"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
