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
                    <th>Type</th>
                    <th>Total Marks</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Gurvic method</td>
                        <td>${results.outputGur}</td>
                    </tr>
                    <tr>
                        <td>Negative method</td>
                        <td>${results.outputNeg}</td>
                    </tr>
                    <tr>
                        <td>Positive method</td>
                        <td>${results.outputPos}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
