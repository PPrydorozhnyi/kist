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
    <title>Violation page</title>
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
    <form:form method="DELETE" action="${contextPath}/violation/${violationForm.id}" modelAttribute="violationForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/violation/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all violations</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">

            <form:form cssClass="f" method="POST" action="${contextPath}/violation/edit" modelAttribute="violationForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View violation</h2>

                <form:hidden path="id"/>
                <form:hidden path="person.id"/>
                <form:hidden path="order.id"/>
                <form:hidden path="violationKind.id"/>
                <form:hidden path="punishKind.id"/>

                <spring:bind path="violationDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Violation date:<br>
                        <form:input type="date" path="violationDate" class="form-control" placeholder="Violation date"
                                    readonly="true"/>
                        <form:errors path="violationDate"/>
                    </div>
                </spring:bind>

                <spring:bind path="person.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Person name:<br>
                        <form:input type="text" path="person.name" class="form-control" placeholder="Person name"
                                    readonly="true"/>
                        <form:errors path="person.name"/>
                    </div>
                </spring:bind>
                <spring:bind path="person.surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Person name:<br>
                        <form:input type="text" path="person.surname" class="form-control"
                                    placeholder="Person surname"
                                    readonly="true"/>
                        <form:errors path="person.surname"/>
                    </div>
                </spring:bind>

                <spring:bind path="order.orderNo">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Order No:<br>
                        <form:input type="text" path="order.orderNo" class="form-control"
                                    placeholder="Order No"
                                    readonly="true"/>
                        <form:errors path="order.orderNo"/>
                    </div>
                </spring:bind>

                <spring:bind path="violationKind.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Violation Kind:<br>
                        <form:input type="text" path="violationKind.name" class="form-control" placeholder="Violation Kind"
                                    readonly="true"/>
                        <form:errors path="violationKind.name"/>
                    </div>
                </spring:bind>

                <spring:bind path="punishKind.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Punish kind:<br>
                        <form:input type="text" path="punishKind.name" class="form-control" placeholder="Punish kind"
                                    readonly="true"/>
                        <form:errors path="punishKind.name"/>
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
