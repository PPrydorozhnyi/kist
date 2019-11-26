<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="students" value="${pageContext.request.getAttribute('students')}"/>
<c:set var="teacherPlans" value="${pageContext.request.getAttribute('teacherPlans')}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student Mark Page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css"/>
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

    <form:form method="POST" action="${contextPath}/student-mark/create" modelAttribute="studentMarkForm"
               class="form-signin">
        <h2 class="form-signin-heading">${studentMarkForm.id != null ? 'Edit' : 'Create'} studentMark</h2>

        <form:hidden path="id"/>

        <%--student--%>
        <spring:bind path="student.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="student"> Student: </label>
                <form:select id="student" path="student.id" class="selectpicker" data-show-subtext="true"
                             data-live-search="true">
                    <c:forEach items="${students}" var="student">
                        <option ${student.id == studentMarkForm.student.id ? 'selected="selected"' : ''}
                                value="${student.id}">${"".concat(student.name).concat(" ").concat(student.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="student.id"/>
            </div>
        </spring:bind>

        <%--TeacherPlan--%>
        <spring:bind path="teacherPlan.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="teacherPlan"> TeacherPlan: </label>
                <form:select path="teacherPlan.id" id="teacherPlan" class="selectpicker" data-show-subtext="true"
                             data-live-search="true">
                    <c:forEach items="${teacherPlans}" var="teacherPlan">
                        <option ${teacherPlan.id == studentMarkForm.teacherPlan.id ? 'selected="selected"' : ''}
                                value="${teacherPlan.id}">
                                ${"".concat(teacherPlan.subject.name).concat(" ")
                                .concat(teacherPlan.tester.name).concat(" ")
                                .concat(teacherPlan.tester.surname).concat(" ")
                                .concat(teacherPlan.group.groupCode)}
                        </option>
                    </c:forEach>
                </form:select>
                <form:errors path="teacherPlan.id"/>
            </div>
        </spring:bind>

        <%--Mark--%>
        <spring:bind path="mark.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="mark"> Mark: </label>
                <form:select path="mark.id" id="mark" class="selectpicker" data-show-subtext="true"
                             data-live-search="true">
                    <c:forEach items="${marks}" var="mark">
                        <option ${mark.id == studentMarkForm.mark.id ? 'selected="selected"' : ''}
                                value="${mark.id}">${mark.value}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="mark.id"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>

</body>
</html>
