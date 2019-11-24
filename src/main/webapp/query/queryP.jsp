<%@ page import="com.peter.kist.model.enums.MarkNames" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="groups" value="${pageContext.request.getAttribute('groups')}"/>
<c:set var="subjects" value="${pageContext.request.getAttribute('subjects')}"/>
<c:set var="persons" value="${pageContext.request.getAttribute('persons')}"/>
<% pageContext.setAttribute("markEnum", MarkNames.values()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Query</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="form-signin-heading" align="center">First query</h2>
    <form:form id="form1" method="GET" action="${contextPath}/queryP/query1" class="form-signin border border-primary">
        <h5 class="form-signin-heading">Query for search all students that have marks higher than average for specified group</h5>

        <%--Group--%>
            <div class="form-group"> Group:
                <select id="groupId" name="groupId">
                    <c:forEach items="${groups}" var="group">
                        <option ${id == group.id ? 'selected="selected"' : ''}
                                value="${group.id}">${group.groupCode}</option>
                    </c:forEach>
                </select>
            </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>
<%--    modelAttribute="semesterForm"--%>
    <br>
    <h2 class="form-signin-heading" align="center">Second query</h2>
    <form:form id="form2" method="GET" action="${contextPath}/queryP/query2"
               class="form-signin border border-primary">
        <h5 class="form-signin-heading">Choose teachers ...</h5>

        <%--subject--%>
            <div class="form-group ${status.error ? 'has-error' : ''}"> Subject:
                <select id="subjectId" name="subjectId">
                    <c:forEach items="${subjects}" var="subject">
                        <option ${id == subject.id ? 'selected="selected"' : ''}
                                value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
            </div>

        <%--teachBeginDate--%>
            <div class="form-group"> Teach Begin Date:
                <input type="date" id="startDate" name="startDate" class="form-control" />
            </div>

        <%--teachEndDate--%>
            <div class="form-group"> Teach End Date:
                <input type="date" id="endDate" name="endDate" class="form-control" />
            </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>

        <br>
    <h2 class="form-signin-heading" align="center">Third query</h2>
    <form:form id="form3" method="GET" action="${contextPath}/queryP/query3"
               class="form-signin border border-primary">
        <h5 class="form-signin-heading">Query for search all students that have marks in specified range and teacher for Math credit</h5>

        <%--Person--%>
            <div class="form-group ${status.error ? 'has-error' : ''}"> Person:
                <select id="personId" name="personId">
                    <c:forEach items="${persons}" var="person">
                        <option ${id == person.id ? 'selected="selected"' : ''}
                                value="${person.id}">${"".concat(person.name).concat(" ").concat(person.surname)}</option>
                    </c:forEach>
                </select>
            </div>

        <%--Mark--%>
        <div class="form-group ${status.error ? 'has-error' : ''}">  Mark:
            <select path="mark" name="mark" cssClass="form-control">
                <c:forEach items="${markEnum}" var="mark">
                    <option value="${mark}">${mark}</option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
