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
    <title>Person Privilege Page</title>
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
    <form:form method="DELETE" action="${contextPath}/person-privilege/person/${personPrivilegeForm.person.id}/privilege/${personPrivilegeForm.privilege.id}"
               modelAttribute="personPrivilegeForm"
               class="form-signin">
        <button class="but" style="background-color:red;" type="submit">Delete</button>
    </form:form>
    <form:form method="GET" action="${contextPath}/person-privilege/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all personPrivileges</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">
            <form:form cssClass="f" method="POST" action="${contextPath}/person-privilege/edit" modelAttribute="personPrivilegeForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View person Privilege</h2>

                <form:hidden path="id"/>
                <form:hidden path="person.id"/>
                <form:hidden path="privilege.id"/>

                <spring:bind path="person.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Person name:<br>
                        <form:input type="text" path="person.name" class="form-control"
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

                <spring:bind path="privilege.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Privilege:<br>
                        <form:input type="text" path="privilege.name" class="form-control"
                                    readonly="true"/>
                        <form:errors path="privilege.name"/>
                    </div>
                </spring:bind>

                <%--beginDate--%>
                <spring:bind path="beginDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="beginDate">   Begin Date: </label>
                        <form:input type="date" id = "beginDate" path="beginDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="beginDate"/>
                    </div>
                </spring:bind>

                <%--endDate--%>
                <spring:bind path="endDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="endDate">   End Date: </label>
                        <form:input type="date" id = "endDate" path="endDate" class="form-control"
                                    readonly="true"/>
                        <form:errors path="endDate"/>
                    </div>
                </spring:bind>

                <%--ground--%>
                <spring:bind path="ground">
                    <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="ground">   Ground: </label>
                        <form:input type="text" id = "ground" path="ground" class="form-control"
                                    readonly="true"/>
                        <form:errors path="ground"/>
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
