<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Cafedra page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/cafedra/create" modelAttribute="cafedraForm" class="form-signin">
        <h2 class="form-signin-heading">${cafedraForm.id != null ? 'Edit' : 'Create'} cafedra</h2>

        <form:hidden path="id" />

        <%--cafedra_name--%>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Cafedra name:
                <form:input type="text" path="name" class="form-control"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>

        <%--cafedra_shifr--%>
        <spring:bind path="shifr">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Cafedra shifr:
                <form:input type="text" path="shifr" class="form-control"
                            autofocus="true"/>
                <form:errors path="shifr"/>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>