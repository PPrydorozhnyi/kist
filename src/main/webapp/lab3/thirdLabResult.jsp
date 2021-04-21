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
                    <th>Alternative</th>
                    <th>Savage</th>
                    <th>Rank</th>
                    <th>Laplace</th>
                    <th>Rank</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${results.savageResult}" var="result" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${result}</td>
                        <td>${results.savageRank[loop.index]}</td>
                        <td>${results.laplaceResult.get(loop.index)}</td>
                        <td>${results.laplaceRank[loop.index]}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
