<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test Kind page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-10">

            <form:form method="POST" action="${contextPath}/test-kind/edit" modelAttribute="testKindForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View testKind</h2>

                <form:hidden path="id"/>

                <%--testKind_name--%>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        TestKind name:<br>
                        <form:input type="text" path="name" class="form-control" placeholder="TestKind name"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="name"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/test-kind/${testKindForm.id}" modelAttribute="testKindForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/test-kind/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all testKinds</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
