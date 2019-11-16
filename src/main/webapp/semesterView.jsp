<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Semester page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-10">

            <form:form method="POST" action="${contextPath}/semester/edit" modelAttribute="semesterForm"
                       class="form-signin">
                <h2 class="form-signin-heading">View semester</h2>

                <form:hidden path="id"/>

                <%--teachBeginDate--%>
                <spring:bind path="teachBeginDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        teachBeginDate:<br>
                        <form:input type="date" path="teachBeginDate" class="form-control" placeholder="teachBeginDate"
                                    readonly="true"/>
                        <form:errors path="teachBeginDate"/>
                    </div>
                </spring:bind>

                <%--teachEndDate--%>
                <spring:bind path="teachEndDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        teachEndDate:<br>
                        <form:input type="date" path="teachEndDate" class="form-control" placeholder="teachEndDate"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="teachEndDate"/>
                    </div>
                </spring:bind>

                <%--sessionBeginDate--%>
                <spring:bind path="sessionBeginDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        sessionBeginDate:<br>
                        <form:input type="date" path="sessionBeginDate" class="form-control" placeholder="sessionBeginDate" readonly="true"/>
                        <form:errors path="sessionBeginDate"/>
                    </div>
                </spring:bind>

                <%--sessionEndDate--%>
                <spring:bind path="sessionEndDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        sessionEndDate:<br>
                        <form:input type="date" path="sessionEndDate" class="form-control" placeholder="sessionEndDate"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="sessionEndDate"/>
                    </div>
                </spring:bind>

                <%--attest1Date--%>
                <spring:bind path="attest1Date">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        attest1Date:<br>
                        <form:input type="date" path="attest1Date" class="form-control" placeholder="attest1Date" readonly="true"/>
                        <form:errors path="attest1Date"/>
                    </div>
                </spring:bind>

                <%--attest2Date--%>
                <spring:bind path="attest2Date">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        attest2Date:<br>
                        <form:input type="date" path="attest2Date" class="form-control" placeholder="attest2Date"
                                    autofocus="true" readonly="true"/>
                        <form:errors path="attest2Date"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form:form>
        </div>
        <div class="col-2 margin-view">
            <form:form method="DELETE" action="${contextPath}/semester/${semesterForm.id}" modelAttribute="semesterForm"
                       class="form-signin">
                <button class="btn btn btn-danger btn-block" type="submit">Delete</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/semester/all" class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View all semesters</button>
            </form:form>
            <form:form method="GET" action="${contextPath}/semester/${semesterForm.id}/groups" modelAttribute="semesterForm"
                       class="form-signin">
                <button class="btn btn btn-info btn-block" type="submit">View groups for semester</button>
            </form:form>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
