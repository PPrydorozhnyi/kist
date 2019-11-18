<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="orderKinds" value="${pageContext.request.getAttribute('orderKinds')}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order page</title>

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/order/create" modelAttribute="orderForm" class="form-signin">
        <h2 class="form-signin-heading">${orderForm.id != null ? 'Edit' : 'Create'} order</h2>

        <form:hidden path="id"/>

        <%--order_no--%>
        <spring:bind path="orderNo">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Order no:
                <form:input type="text" id = "orderNo" path="orderNo" class="form-control"
                            autofocus="true"/>
                <form:errors path="orderNo"/>
            </div>
        </spring:bind>

        <%--order_date--%>
        <spring:bind path="orderDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Order creation date:
                <form:input type="date" path="orderDate" class="form-control" />
                <form:errors path="orderDate"/>
            </div>
        </spring:bind>

        <%--order_text--%>
        <spring:bind path="orderText">
            <div class="form-group ${status.error ? 'has-error' : ''}">  Order text:
                <form:textarea type="text" path="orderText" class="form-control"/>
                <form:errors path="orderText"/>
            </div>
        </spring:bind>

        <%--order Kind--%>
        <spring:bind path="orderKind.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="kind_name">   Order kind: </label>
                <form:select path="orderKind.id" id = "kind_name" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${orderKinds}" var="orderKind">
                        <option ${orderKind.id == orderForm.orderKind.id ? 'selected="selected"' : ''}
                                value="${orderKind.id}">${orderKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="orderKind.id"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
