<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Semester page</title>

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

    <form:form method="POST" action="${contextPath}/semester/create" modelAttribute="semesterForm" class="form-signin">
        <h2 class="form-signin-heading">${semesterForm.id != null ? 'Edit' : 'Create'} semester</h2>

        <form:hidden path="id" />

        <%--teachBeginDate--%>
        <spring:bind path="teachBeginDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Teach Begin Date:
                <form:input type="date" path="teachBeginDate" class="form-control" />
                <form:errors path="teachBeginDate"/>
            </div>
        </spring:bind>

        <%--teachEndDate--%>
        <spring:bind path="teachEndDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Teach End Date:
                <form:input type="date" path="teachEndDate" class="form-control"
                            autofocus="true"/>
                <form:errors path="teachEndDate"/>
            </div>
        </spring:bind>

        <%--sessionBeginDate--%>
        <spring:bind path="sessionBeginDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Session Begin Date:
                <form:input type="date" path="sessionBeginDate" class="form-control" />
                <form:errors path="sessionBeginDate"/>
            </div>
        </spring:bind>

        <%--sessionEndDate--%>
        <spring:bind path="sessionEndDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Session End Date:
                <form:input type="date" path="sessionEndDate" class="form-control"
                            autofocus="true"/>
                <form:errors path="sessionEndDate"/>
            </div>
        </spring:bind>

        <%--attest1Date--%>
        <spring:bind path="attest1Date">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Attest1 date:
                <form:input type="date" path="attest1Date" class="form-control" />
                <form:errors path="attest1Date"/>
            </div>
        </spring:bind>

        <%--attest2Date--%>
        <spring:bind path="attest2Date">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Attest2 date:
                <form:input type="date" path="attest2Date" class="form-control"
                            autofocus="true"/>
                <form:errors path="attest2Date"/>
            </div>
        </spring:bind>
        <%--        &lt;%&ndash;subject_name&ndash;%&gt;--%>
        <%--        <spring:bind path="subjectName">--%>
        <%--            <div class="form-group ${status.error ? 'has-error' : ''}">--%>
        <%--                <form:input type="text" path="subjectName" class="form-control" placeholder="Subject Name"/>--%>
        <%--                <form:errors path="subjectName"/>--%>
        <%--            </div>--%>
        <%--        </spring:bind>--%>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
