<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="groups" value="${pageContext.request.getAttribute('groups')}"/>
<c:set var="subjects" value="${pageContext.request.getAttribute('subjects')}"/>
<c:set var="persons" value="${pageContext.request.getAttribute('persons')}"/>
<c:set var="marks" value="${pageContext.request.getAttribute('marks')}"/>

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
            <div class="form-group ${status.error ? 'has-error' : ''}"> Group:
                <select id="groupId" name="groupId">
                    <c:forEach items="${groups}" var="group">
                        <option ${id == group.id ? 'selected="selected"' : ''}
                                value="${group.id}">${group.groupCode}</option>
                    </c:forEach>
                </select>
            </div>

        <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>

<%--    <form:form id="form2" method="POST" action="${contextPath}/query/query2"--%>
<%--               class="form-signin">--%>
<%--        <h2 class="form-signin-heading">Second query</h2>--%>
<%--        <h5 class="form-signin-heading">Choose teachers ...</h5>--%>

<%--        &lt;%&ndash;subject&ndash;%&gt;--%>
<%--        <spring:bind path="subject.id">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}"> <label for="subject">   Subject: </label>--%>
<%--                <form:select id = "subject" path="subject.id" class="selectpicker" data-show-subtext="true" data-live-search="true">--%>
<%--                    <c:forEach items="${subjects}" var="subject">--%>
<%--                        <option ${subject.id == queryForm.subject.id ? 'selected="selected"' : ''}--%>
<%--                                value="${subject.id}">${subject.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </form:select>--%>
<%--                <form:errors path="subject.id"/>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        &lt;%&ndash;teachBeginDate&ndash;%&gt;--%>
<%--        <spring:bind path="teachBeginDate">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}"> Teach Begin Date:--%>
<%--                <form:input type="date" path="teachBeginDate" class="form-control" />--%>
<%--                <form:errors path="teachBeginDate"/>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        &lt;%&ndash;teachEndDate&ndash;%&gt;--%>
<%--        <spring:bind path="teachEndDate">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}"> Teach End Date:--%>
<%--                <form:input type="date" path="teachEndDate" class="form-control"--%>
<%--                            autofocus="true"/>--%>
<%--                <form:errors path="teachEndDate"/>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        <button class="btn btn-lg btn-primary btn-block" type="submit">Process</button>--%>
<%--    </form:form>--%>

<%--    <form:form id="form3" method="POST" action="${contextPath}/query/query3"--%>
<%--               class="form-signin">--%>
<%--        <h2 class="form-signin-heading">Third query</h2>--%>
<%--        <h5 class="form-signin-heading">Choose students ...</h5>--%>

<%--        &lt;%&ndash;Person&ndash;%&gt;--%>
<%--        <spring:bind path="person.id">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="teach_name"> Person: </label>--%>
<%--                <form:select id="teach_name" path="person.id" class="selectpicker" data-show-subtext="true"--%>
<%--                             data-live-search="true">--%>
<%--                    <c:forEach items="${persons}" var="person">--%>
<%--                        <option ${person.id == queryForm.person.id ? 'selected="selected"' : ''}--%>
<%--                                value="${person.id}">${"".concat(person.name).concat(" ").concat(person.surname)}</option>--%>
<%--                    </c:forEach>--%>
<%--                </form:select>--%>
<%--                <form:errors path="person.id"/>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        &lt;%&ndash;Mark&ndash;%&gt;--%>
<%--        <spring:bind path="mark.id">--%>
<%--            <div class="form-group ${status.error ? 'has-error' : ''}">Person:--%>
<%--                <form:select path="mark.id" class="selectpicker" data-show-subtext="true"--%>
<%--                             data-live-search="true">--%>
<%--                    <c:forEach items="${marks}" var="mark">--%>
<%--                        <option ${mark.id == queryForm.mark.id ? 'selected="selected"' : ''}--%>
<%--                                value="${mark.id}">${"".concat(mark.name).concat(" ").concat(mark.surname)}</option>--%>
<%--                    </c:forEach>--%>
<%--                </form:select>--%>
<%--                <form:errors path="mark.id"/>--%>
<%--            </div>--%>
<%--        </spring:bind>--%>

<%--        <button class="btn btn-lg btn-primary btn-block" type="submit">Process</button>--%>
<%--    </form:form>--%>
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
