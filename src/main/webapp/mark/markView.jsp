<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Mark page</title>
    <link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
</head>

<body>
<div class = "mainmenu">
    <ul class = "list">
        <li><a class="link" href="${contextPath}/welcome">Home page</a></li>
        <li><a class="link" href="${contextPath}/queryY">Query</a></li>
        <li><form id="logoutForm" class="link" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <a class="link" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </form></li>
    </ul>
</div>
<div class="container">
    <form:form method="DELETE" action="${contextPath}/mark/${markForm.id}" modelAttribute="markForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/mark/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all marks</button>
    </form:form>
        <hr>

    <div class="row">
        <div class="col-10">

            <form:form cssClass="f" method="POST" action="${contextPath}/mark/edit" modelAttribute="markForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View mark</h2>

                <form:hidden path="id"/>

                <%--NAME--%>
                <spring:bind path="value">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Mark name:<br>
                        <form:input type="text" path="value" class="form-control" placeholder="Mark value"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="value"/>
                    </div>
                </spring:bind>

                <button class="but" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">

    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
