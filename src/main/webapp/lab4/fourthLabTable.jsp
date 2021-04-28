<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Fourth Lab</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-10">
            <form:form method="POST" action="${contextPath}/pareto/calculate" modelAttribute="input">

                <spring:bind path="amountOfExperts">
                    <form:input type="hidden" path="amountOfExperts" class="form-control"
                                autofocus="true"/>
                </spring:bind>

                <spring:bind path="amountOfAlternatives">
                    <form:input type="hidden" path="amountOfAlternatives" class="form-control"
                                autofocus="true"/>
                </spring:bind>

                <table class="table table-striped table-dark table-bordered table-hover">
                    <% for (int i = 0; i < (Integer) request.getAttribute("amountOfExperts"); ++i) { %>
                    <tr>
                        <td>Expert <% out.print(i + 1); %></td>
                        <% for (int j = 0; j < 2 * (Integer) request.getAttribute("amountOfAlternatives") - 1; ++j) { %>
                        <td>
                        <form:select path="inputValues" class="form-control">
                        <% if (j % 2 == 0) {%>

                            <% for(int optionI = 0; optionI < (Integer) request.getAttribute("amountOfAlternatives"); ++optionI) { %>
                            <% String valueI = "y" + (optionI + 1); %>
                            <form:option value = "<%=valueI%>" >y <% out.print(optionI + 1); %></form:option>
                            <% } %>
                        <% } else {%>
                            <form:option value="1"> ">" </form:option>
                            <form:option value="0"> "~" </form:option>

                        <% } %>
                            </form:select>
                        </td>
                        <% } %>
                    </tr>
                    <% } %>
                </table>
                <button class="btn btn-lg btn-success float-right" type="submit">Submit</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
