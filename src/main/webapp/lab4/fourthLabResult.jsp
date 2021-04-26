<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>

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
                    <th>Alternatives</th>
                    <th colspan="${results.rankedMap.get(results.pareto.stream().findFirst().get()).size()}">Experts</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${results.rankedMap}" var="result">
                    <tr>
                        <td>${result.key}</td>
                        <c:forEach items="${result.value}" var ="current">
                        <td>${current}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th>Alternatives that better then other</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${results.pareto}" var="result" varStatus="loop">
                    <tr>
                        <td>${result}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>
