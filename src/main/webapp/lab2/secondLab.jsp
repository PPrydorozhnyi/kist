<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Second Lab</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/gurvic/input" modelAttribute="init" class="form-signin">

        <spring:bind path="amountOfStage">
            <div class="form-group">Number of conditions:
                <form:input type="text" path="amountOfStage" class="form-control"
                            autofocus="true"/>
            </div>
        </spring:bind>

        <spring:bind path="amountOfSolving">
            <div class="form-group">Number of solution options:
                <form:input type="text" path="amountOfSolving" class="form-control"
                            autofocus="true"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-success btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
