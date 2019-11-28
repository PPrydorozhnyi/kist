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
    <title>Speciality page</title>
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
    <form:form method="DELETE" action="${contextPath}/speciality/${specialityForm.id}" modelAttribute="specialityForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/speciality/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all specialities</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">

            <form:form cssClass="f" method="POST" action="${contextPath}/speciality/edit" modelAttribute="specialityForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View speciality</h2>

                <form:hidden path="id"/>
                <form:hidden path="cafedra.id"/>

                <%--speciality_name--%>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="name" class="form-control" placeholder="Speciality name"
                                    readonly="true"/>
                        <form:errors path="name"/>
                    </div>
                </spring:bind>

                <%--speciality_shifr--%>
                <spring:bind path="shifr">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="shifr" class="form-control" placeholder="Speciality shifr"
                                    readonly="true"/>
                        <form:errors path="shifr"/>
                    </div>
                </spring:bind>

                <spring:bind path="cafedra.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Cafedra name:<br>
                        <form:input type="text" path="cafedra.name" class="form-control" placeholder="Cafedra name"
                                    readonly="true"/>
                        <form:errors path="cafedra.name"/>
                    </div>
                </spring:bind>

                <button class="but" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
