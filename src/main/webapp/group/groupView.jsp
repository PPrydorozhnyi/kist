<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Group page</title>

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

            <form:form method="POST" action="${contextPath}/group/edit" modelAttribute="groupForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View group</h2>

                <form:hidden path="id"/>
                <form:hidden path="speciality.id"/>

                <%--groupCode--%>
                <spring:bind path="groupCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Group code:<br>
                        <form:input type="text" path="groupCode" class="form-control" placeholder="Group code"
                                    readonly="true"/>
                        <form:errors path="groupCode"/>
                    </div>
                </spring:bind>

                <%--groupCreateDate--%>
                <spring:bind path="groupCreateDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Group creation date:<br>
                        <form:input type="date" path="groupCreateDate" class="form-control" placeholder="Group creation date"
                                    readonly="true"/>
                        <form:errors path="groupCreateDate"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/group/${groupForm.id}" modelAttribute="groupForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/group/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all groups</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
