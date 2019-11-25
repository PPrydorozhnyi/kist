<%@ page import="com.peter.kist.model.enums.MarkNames" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="privileges" value="${pageContext.request.getAttribute('privileges')}"/>
<c:set var="specialities" value="${pageContext.request.getAttribute('specialities')}"/>
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
    <form:form id="form1" method="GET" action="${contextPath}/queryY/query1" class="form-signin border border-primary">
        <h5 class="form-signin-heading">Query for search all students that have marks higher than average for specified group</h5>

        <%--Privilege--%>
        <div class="form-group"> Privilege:
            <select id="privilegeId" name="privilegeId">
                <c:forEach items="${privileges}" var="privilege">
                    <option ${id == privilege.id ? 'selected="selected"' : ''}
                            value="${privilege.id}">${privilege.name}</option>
                </c:forEach>
            </select>
        </div>

        <%--privBeginDate--%>
        <div class="form-group"> Privilege begin date:
            <input type="date" id="startDate" name="startDate" class="form-control" />
        </div>

        <%--privEndDate--%>
        <div class="form-group"> Privilege end date:
            <input type="date" id="endDate" name="endDate" class="form-control" />
        </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>


    <br>
    <h2 class="form-signin-heading" align="center">Second query</h2>
    <form:form id="form2" method="GET" action="${contextPath}/queryY/query2"
               class="form-signin border border-primary">
        <h5 class="form-signin-heading">Choose teachers ...</h5>

        <%--violationDate--%>
        <div class="form-group"> Violation date:
            <input type="date" id="violationDate" name="violationDate" class="form-control" />
        </div>

        <%--teachEndDate--%>
        <div class="form-group"> Order date:
            <input type="date" id="orderDate" name="orderDate" class="form-control" />
        </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>


    <br>
    <h2 class="form-signin-heading" align="center">Third query</h2>
    <form:form id="form3" method="GET" action="${contextPath}/queryY/query3"
               class="form-signin border border-primary">
        <h5 class="form-signin-heading">Query for search all students that have marks in specified range and teacher for Math credit</h5>

        <%--Speciality--%>
        <div class="form-group ${status.error ? 'has-error' : ''}"> Speciality:
            <select id="specialityId" name="specialityId">
                <c:forEach items="${specialities}" var="speciality">
                    <option ${id == speciality.id ? 'selected="selected"' : ''}
                            value="${speciality.id}">${speciality.name}</option>
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
