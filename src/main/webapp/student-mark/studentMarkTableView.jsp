<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student Mark Page</title>

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
                    <th>Student</th>
                    <th>Teacher Plan</th>
                    <th>Mark</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${studentMarks}" var="studentMark">
                    <tr>
                        <td>
                            <a href="${contextPath}/student-mark/student/${studentMark.student.id}/teacherPlan/${studentMark.teacherPlan.id}">
                                    ${"".concat(studentMark.student.name).concat(" ").concat(studentMark.student.surname)}</a>
                        </td>
                        <td>${studentMark.teacherPlan.name}</td>
                        <td>${studentMark.mark.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <form:form cssClass="col-2 margin-table-view" method="GET" action="${contextPath}/student-mark/create"
                   class="form-signin">
            <button class="btn btn btn-success" type="submit">Create</button>
        </form:form>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
