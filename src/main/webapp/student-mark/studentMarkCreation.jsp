<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="students" value="${pageContext.request.getAttribute('students')}"/>
<c:set var="teacherPlans" value="${pageContext.request.getAttribute('teacherPlans')}"/>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Student Mark Page</title>
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

    <form:form cssClass="f" method="POST" action="${contextPath}/student-mark/create" modelAttribute="studentMarkForm"
               class="form-signin">
        <h2 class="form-signin-heading">${studentMarkForm.id != null ? 'Edit' : 'Create'} studentMark</h2>

        <form:hidden path="id"/>

        <%--student--%>
        <spring:bind path="student.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="student"> Student: </label>
                <form:select id="student" path="student.id">
                    <c:forEach items="${students}" var="student">
                        <option ${student.id == studentMarkForm.student.id ? 'selected="selected"' : ''}
                                value="${student.id}">${"".concat(student.name).concat(" ").concat(student.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="student.id"/>
            </div>
        </spring:bind>

        <%--TeacherPlan--%>
        <spring:bind path="teacherPlan.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="teacherPlan"> TeacherPlan (testDate): </label>
                <form:select path="teacherPlan.id" id="teacherPlan">
                    <c:forEach items="${teacherPlans}" var="teacherPlan">
                        <option ${teacherPlan.id == studentMarkForm.teacherPlan.id ? 'selected="selected"' : ''}
                                    value="${teacherPlan.id}">${teacherPlan.testDate}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="teacherPlan.id"/>
            </div>
        </spring:bind>

        <%--Mark--%>
        <spring:bind path="mark.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="mark"> Mark: </label>
                <form:select path="mark.id" id="mark">
                    <c:forEach items="${marks}" var="mark">
                        <option ${mark.id == studentMarkForm.mark.id ? 'selected="selected"' : ''}
                                value="${mark.id}">${mark.value}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="mark.id"/>
            </div>
        </spring:bind>

        <button class="but" type="submit">Submit</button>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>

</body>
</html>
