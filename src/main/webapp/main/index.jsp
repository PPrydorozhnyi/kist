<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Main</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row mt-5 justify-content-center">
        <div class="col-7">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-info active">
                    Available Methods
                </a>
                <a href="${contextPath}/alternative" class="list-group-item list-group-item-primary">The method of direct assessment of the comparative advantage of alternatives</a>
                <a href="${contextPath}/gurvic" class="list-group-item list-group-item-secondary">Criteria for decision-making in conditions of uncertainty</a>
                <a href="${contextPath}/laplace" class="list-group-item list-group-item-success">Savage and Laplace criteria</a>
                <a href="${contextPath}/pareto" class="list-group-item list-group-item-danger">Direct search method for constructing a Pareto set</a>
            </div>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
