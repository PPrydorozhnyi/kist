<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="semesters" value="${pageContext.request.getAttribute('semesters')}"/>
<c:set var="groups" value="${pageContext.request.getAttribute('groups')}"/>
<c:set var="testers" value="${pageContext.request.getAttribute('testers')}"/>
<c:set var="testkinds" value="${pageContext.request.getAttribute('testkinds')}"/>
<c:set var="subjects" value="${pageContext.request.getAttribute('subjects')}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teacher Plan page</title>

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/teacher-plan/create" modelAttribute="teacherPlanForm" class="form-signin">
        <h2 class="form-signin-heading">${teacherPlanForm.id != null ? 'Edit' : 'Create'} teacherPlan</h2>

        <form:hidden path="id"/>

        <%--tester--%>
        <spring:bind path="tester.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="tester">   Tester: </label>
                <form:select id = "tester" path="tester.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${testers}" var="tester">
                        <option ${tester.id == teacherPlanForm.tester.id ? 'selected="selected"' : ''}
                                value="${tester.id}">${"".concat(tester.name).concat(" ").concat(tester.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="tester.id"/>
            </div>
        </spring:bind>

        <%--semester--%>
        <spring:bind path="semester.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="semester">   Semester: </label>
                <form:select id = "semester" path="semester.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${semesters}" var="semester">
                        <option ${semester.id == teacherPlanForm.semester.id ? 'selected="selected"' : ''}
                                value="${semester.id}">${semester.teachBeginDate}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="semester.id"/>
            </div>
        </spring:bind>

        <%--group--%>
        <spring:bind path="group.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="group">   Group: </label>
                <form:select id = "group" path="group.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${groups}" var="group">
                        <option ${group.id == teacherPlanForm.group.id ? 'selected="selected"' : ''}
                                value="${group.id}">${group.groupCode}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="group.id"/>
            </div>
        </spring:bind>

        <%--testKind--%>
        <spring:bind path="testKind.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="testKind">   TestKind: </label>
                <form:select id = "testKind" path="testKind.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${testKinds}" var="testKind">
                        <option ${testKind.id == teacherPlanForm.testKind.id ? 'selected="selected"' : ''}
                                value="${testKind.id}">${testKind.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="testKind.id"/>
            </div>
        </spring:bind>

        <%--subject--%>
        <spring:bind path="subject.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="subject">   Subject: </label>
                <form:select id = "subject" path="subject.id" class="selectpicker" data-show-subtext="true" data-live-search="true">
                    <c:forEach items="${subjects}" var="subject">
                        <option ${subject.id == teacherPlanForm.subject.id ? 'selected="selected"' : ''}
                                value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="subject.id"/>
            </div>
        </spring:bind>

        <%--testDate--%>
        <spring:bind path="testDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="testDate">   Test Date: </label>
                <form:input type="date" id = "testDate" path="testDate" class="form-control"
                            autofocus="true"/>
                <form:errors path="testDate"/>
            </div>
        </spring:bind>

        <%--obligatory--%>
        <spring:bind path="obligatory">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="obligatory">   Obligatory: </label>
                <form:checkbox id = "obligatory" path="obligatory" class=""
                            autofocus="true"/>
                <form:errors path="obligatory"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
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
