<%@ page import="com.peter.kist.model.Sex" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% pageContext.setAttribute("sexnEnum", Sex.values()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-10">

            <form:form method="POST" action="${contextPath}/student/edit" modelAttribute="studentForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View student</h2>

                <form:hidden path="id"/>

                <%--NAME--%>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Student name:<br>
                        <form:input type="text" path="name" class="form-control" placeholder="Student name"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="name"/>
                    </div>
                </spring:bind>

                <%--SURNAME--%>
                <spring:bind path="surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Student surname:<br>
                        <form:input type="text" path="surname" class="form-control" placeholder="Student surname"
                                    readonly="true"/>
                        <form:errors path="surname"/>
                    </div>
                </spring:bind>

                <%--Address--%>
                <spring:bind path="address">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Address:<br>
                        <form:input type="text" path="address" class="form-control" placeholder="Address"
                                    readonly="true"/>
                        <form:errors path="address"/>
                    </div>
                </spring:bind>

                <%--Sex--%>
                <spring:bind path="sex">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Sex:<br>
                        <form:input type="text" path="sex" class="form-control" placeholder="Sex" readonly="true"/>
                    </div>
                </spring:bind>

                <%--Birth_date--%>
                <spring:bind path="birthDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Student birth date:<br>
                        <form:input type="date" path="birthDate" class="form-control" readonly="true"/>
                        <form:errors path="birthDate"/>
                    </div>
                </spring:bind>

                <%--Birth_place--%>
                <spring:bind path="birthPlace">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Birth place:<br>
                        <form:input type="text" path="birthPlace" class="form-control" placeholder="Birth place"
                                    readonly="true"/>
                        <form:errors path="birthPlace"/>
                    </div>
                </spring:bind>

                <%--Birth_place--%>
                <spring:bind path="telephoneNumber">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Telephone Number:<br>
                        <form:input type="text" path="telephoneNumber" class="form-control"
                                    placeholder="Telephone Number" readonly="true"/>
                        <form:errors path="telephoneNumber"/>
                    </div>
                </spring:bind>

                <%--BOOK_NUMBER--%>
                <spring:bind path="bookNumber">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Book number:<br>
                        <form:input type="text" path="bookNumber" class="form-control" placeholder="Book number"
                                    readonly="true"/>
                        <form:errors path="bookNumber"/>
                    </div>
                </spring:bind>

                <%--LAST GROUP JOIN DATE--%>
                <spring:bind path="groupPuttingDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Last group putting date: <br>
                        <form:input type="date" path="groupPuttingDate" class="form-control"
                                       title="Last group putting date" readonly="true"/>
                        <form:errors path="groupPuttingDate"/>
                    </div>
                </spring:bind>

                <%--NOTE--%>
                <spring:bind path="note">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Note about student:
                        <form:textarea type="text" path="note" class="form-control" placeholder="Note about student"
                                       readonly="true"/>
                        <form:errors path="note"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/student/${studentForm.id}" modelAttribute="studentForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/student/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all students</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/student/${studentForm.id}/groups" modelAttribute="studentForm"
                       class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View groups for student</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
