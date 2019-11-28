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
    <title>Order page</title>
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
    <form:form method="DELETE" action="${contextPath}/order/${orderForm.id}" modelAttribute="orderForm"
                                  class="form-signin">
    <button class="but" style="background-color:red;" type="submit">Delete</button>
</form:form>
    <form:form method="GET" action="${contextPath}/order/all" class="form-signin">
        <button class="but" style="background-color:lightblue;" type="submit">View all orders</button>
    </form:form>
    <hr>

    <div class="row">
        <div class="col-10">

            <form:form cssClass="f" method="POST" action="${contextPath}/order/edit" modelAttribute="orderForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View order</h2>

                <form:hidden path="id"/>
                <form:hidden path="orderKind.id"/>

                <%--orderNo--%>
                <spring:bind path="orderNo">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="orderNo" class="form-control" placeholder="Order no"
                                    readonly="true"/>
                        <form:errors path="orderNo"/>
                    </div>
                </spring:bind>

                <%--orderDate--%>
                <spring:bind path="orderDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Order creation date:<br>
                        <form:input type="date" path="orderDate" class="form-control" placeholder="Order creation date"
                                    readonly="true"/>
                        <form:errors path="orderDate"/>
                    </div>
                </spring:bind>

                <%--orderText--%>
                <spring:bind path="orderText">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Note about student:
                        <form:textarea type="text" path="orderText" class="form-control" placeholder="Order text"
                                       readonly="true"/>
                        <form:errors path="orderText"/>
                    </div>
                </spring:bind>

                <spring:bind path="orderKind.name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        Order kind:<br>
                        <form:input type="text" path="orderKind.name" class="form-control" placeholder="Order Kind"
                                    readonly="true"/>
                        <form:errors path="orderKind.name"/>
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
