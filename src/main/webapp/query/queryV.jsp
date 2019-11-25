<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="groups" value="${pageContext.request.getAttribute('groups')}"/>
<c:set var="violationKinds" value="${pageContext.request.getAttribute('violationKinds')}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Query</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h4 class="form-signin-heading" align="left">First query</h4>
    <form:form id="form1" method="GET" action="${contextPath}/queryV/query1" class="form-signin">
        <h6><em>Query for search all students that have marks higher <br> than average for specified group</em></h6>

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

    <br>

    <h4 class="form-signin-heading" align="left">Second query</h4>
    <form:form id="form2" method="GET" action="${contextPath}/queryV/query2" class="form-signin">
    <h6><em>Query for search all students that have one type <br> of violation kind</em></h6>

    <%--violationKind--%>
    <div class="form-group"> Violation Kind:
    <select id="violationKindId" name="violationKindId">
    <c:forEach items="${violationKinds}" var="violationKind">
        <option ${id == violationKind.id ? 'selected="selected"' : ''}
                value="${violationKind.id}">${violationKind.name}</option>
    </c:forEach>
    </select>
    </div>

    <button class="btn btn-md btn-primary" type="submit">Process</button>
    </form:form>

    <br>

    <h4 class="form-signin-heading" align="left">Third query</h4>
    <form:form id="form3" method="GET" action="${contextPath}/queryV/query3" class="form-signin">
        <h6><em>Query for search all students and punish that was used  <br>  more times than others</em></h6>
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
