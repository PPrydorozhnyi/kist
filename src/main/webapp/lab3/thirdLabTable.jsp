<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Third Lab</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-10">
            <form:form method="POST" action="${contextPath}/laplace/calculate" modelAttribute="input">

                <spring:bind path="amountOfCondition">
                    <form:input type="hidden" path="amountOfCondition" class="form-control"
                                autofocus="true"/>
                </spring:bind>

                <spring:bind path="amountOfAlternative">
                    <form:input type="hidden" path="amountOfAlternative" class="form-control"
                                autofocus="true"/>
                </spring:bind>

                <table class="table table-bordered table-hover">
                    <thead class="thead-dark">
                    <tr>
                        <th>Alternative</th>
                    </tr>
                    </thead>
                    <% for(int i = 0; i < (Integer)request.getAttribute("amountOfAlternative"); ++i){ %>
                    <tr>
                        <td>Alternative <% out.print(i + 1); %></td>
                        <% for(int j = 0; j < (Integer)request.getAttribute("amountOfCondition"); ++j){ %>
                        <td>
                            <form:input type="text" path="inputValues" class="form-control"
                                        autofocus="true"/>
                            <form:errors path="inputValues"/>
                        </td>
                        <% } %>
                    </tr>
                    <% } %>
                </table>
                <button class="btn btn-lg btn-primary" type="submit">Submit</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>