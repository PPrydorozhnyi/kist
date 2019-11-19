<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order page</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-10">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th>Order no</th>
                    <th>Order date</th>
                    <th>Order text</th>
                    <th>Order kind</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td><a href="${contextPath}/order/${order.id}">${order.orderNo}</a></td>
                        <td>${order.orderDate}</td>
                        <td>${order.orderText}</td>
                        <td>${order.orderKind.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/order/create"
                   class="form-signin">
            <button class="btn btn btn-success" type="submit">Create</button>
        </form:form>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
