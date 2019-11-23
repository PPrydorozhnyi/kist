<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="persons" value="${pageContext.request.getAttribute('persons')}"/>
<c:set var="privileges" value="${pageContext.request.getAttribute('privileges')}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Person Privilege Page</title>

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/my.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css"/>
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/person-privilege/create" modelAttribute="personPrivilegeForm"
               class="form-signin">
        <h2 class="form-signin-heading">${personPrivilegeForm.id != null ? 'Edit' : 'Create'} personPrivilege</h2>

        <form:hidden path="id"/>

        <%--Person--%>
        <spring:bind path="person.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="teach_name"> Person: </label>
                <form:select id="teach_name" path="person.id" class="selectpicker" data-show-subtext="true"
                             data-live-search="true">
                    <c:forEach items="${persons}" var="person">
                        <option ${person.id == personPrivilegeForm.person.id ? 'selected="selected"' : ''}
                                value="${person.id}">${"".concat(person.name).concat(" ").concat(person.surname)}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="person.id"/>
            </div>
        </spring:bind>

        <%--Privilege--%>
        <spring:bind path="privilege.id">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="kind_name"> Privilege: </label>
                <form:select path="privilege.id" id="kind_name" class="selectpicker" data-show-subtext="true"
                             data-live-search="true">
                    <c:forEach items="${privileges}" var="privilege">
                        <option ${privilege.id == personPrivilegeForm.privilege.id ? 'selected="selected"' : ''}
                                value="${privilege.id}">${privilege.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="privilege.id"/>
            </div>
        </spring:bind>

        <%--beginDate--%>
        <spring:bind path="beginDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="beginDate"> Begin Date: </label>
                <form:input type="date" id="beginDate" path="beginDate" class="form-control"
                            autofocus="true"/>
                <form:errors path="beginDate"/>
            </div>
        </spring:bind>

        <%--endDate--%>
        <spring:bind path="endDate">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="endDate"> End Date: </label>
                <form:input type="date" id="endDate" path="endDate" class="form-control"
                            autofocus="true"/>
                <form:errors path="endDate"/>
            </div>
        </spring:bind>

        <%--ground--%>
        <spring:bind path="ground">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label for="ground"> Ground: </label>
                <form:input type="text" id="ground" path="ground" class="form-control"
                            autofocus="true"/>
                <form:errors path="ground"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
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
