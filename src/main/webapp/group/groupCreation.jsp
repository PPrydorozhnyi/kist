<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="specialities" value="${pageContext.request.getAttribute('specialities')}"/>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Group page</title>
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

    <form:form cssClass="f" method="POST" action="${contextPath}/group/create" modelAttribute="groupForm" class="form-signin">
        <h2 class="form-signin-heading">${groupForm.id != null ? 'Edit' : 'Create'} group</h2>

        <form:hidden path="id"/>

        <%--groupCode--%>
        <spring:bind path="groupCode">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Group code:
                <form:input type="text" id = "groupCode" path="groupCode" class="form-control"
                            autofocus="true"/>
                <form:errors path="groupCode"/>
            </div>
        </spring:bind>

        <%--groupCreateDate--%>
        <spring:bind path="groupCreateDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> Group creation date:
                <form:input type="date" path="groupCreateDate" class="form-control" />
                <form:errors path="groupCreateDate"/>
            </div>
        </spring:bind>

        <%--speciality--%>
        <spring:bind path="speciality.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="specialityName">   Speciality name: </label>
                <form:select path="speciality.id" id = "specialityName">
                    <c:forEach items="${specialities}" var="speciality">
                        <option ${speciality.id == groupForm.speciality.id ? 'selected="selected"' : ''}
                                value="${speciality.id}">${speciality.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="speciality.id"/>
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
