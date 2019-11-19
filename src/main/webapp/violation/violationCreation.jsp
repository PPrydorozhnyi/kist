<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="people" value="${pageContext.request.getAttribute('people')}"/>
<c:set var="orders" value="${pageContext.request.getAttribute('orders')}"/>
<c:set var="violationKinds" value="${pageContext.request.getAttribute('violationKinds')}"/>
<c:set var="punishKinds" value="${pageContext.request.getAttribute('punishKinds')}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Violation page</title>

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/violation/create" modelAttribute="violationForm" class="form-signin">
        <h2 class="form-signin-heading">${violationForm.id != null ? 'Edit' : 'Create'} violation</h2>

        <form:hidden path="id"/>

        <%--violationDate--%>
        <spring:bind path="violationDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Violation date:
                <form:input type="date" path="violationDate" class="form-control" />
                <form:errors path="violationDate"/>
            </div>
        </spring:bind>

        <%--Person name--%>
        <spring:bind path="person.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="teach_name">   Person name: </label>
                <form:select id = "teach_name" path="person.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${people}" var="person">
                        <option ${person.id == violationForm.person.id ? 'selected="selected"' : ''}
                                value="${person.id}">${"".concat(person.name).concat(" ").concat(person.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="person.id"/>
            </div>
        </spring:bind>

        <%--orderNo--%>
        <spring:bind path="order.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="orderNo">   Order No: </label>
                <form:select id = "orderNo" path="order.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${orders}" var="order">
                        <option ${order.id == violationForm.order.id ? 'selected="selected"' : ''}
                                value="${order.id}">${order.orderNo}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="order.id"/>
            </div>
        </spring:bind>

        <%--violationKind--%>
        <spring:bind path="violationKind.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="violationKind">   Violation kind: </label>
                <form:select path="violationKind.id" id = "violationKind" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${violationKinds}" var="violationKind">
                        <option ${violationKind.id == violationForm.violationKind.id ? 'selected="selected"' : ''}
                                value="${violationKind.id}">${violationKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="violationKind.id"/>
            </div>
        </spring:bind>

        <%--punishKind--%>
        <spring:bind path="punishKind.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="punishKind">   Punish kind: </label>
                <form:select path="punishKind.id" id = "punishKind" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${punishKinds}" var="punishKind">
                        <option ${punishKind.id == violationForm.punishKind.id ? 'selected="selected"' : ''}
                                value="${punishKind.id}">${punishKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="punishKind.id"/>
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
