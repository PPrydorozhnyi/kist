<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="people" value="${pageContext.request.getAttribute('people')}"/>
<c:set var="orders" value="${pageContext.request.getAttribute('orders')}"/>
<c:set var="violationKinds" value="${pageContext.request.getAttribute('violationKinds')}"/>
<c:set var="punishKinds" value="${pageContext.request.getAttribute('punishKinds')}"/>
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

    <form:form cssClass="f" method="POST" action="${contextPath}/violation/create" modelAttribute="violationForm" class="form-signin">
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
                <form:select id = "teach_name" path="person.id">
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
                <form:select id = "orderNo" path="order.id">
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
                <form:select path="violationKind.id" id = "violationKind">
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
                <form:select path="punishKind.id" id = "punishKind">
                    <c:forEach items="${punishKinds}" var="punishKind">
                        <option ${punishKind.id == violationForm.punishKind.id ? 'selected="selected"' : ''}
                                value="${punishKind.id}">${punishKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="punishKind.id"/>
            </div>
        </spring:bind>

        <button class="but" type="submit">Submit</button>
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
