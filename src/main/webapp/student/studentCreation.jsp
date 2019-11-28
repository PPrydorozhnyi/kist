<%@ page import="com.peter.kist.model.enums.Sex" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% pageContext.setAttribute("sexnEnum", Sex.values()); %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Student page</title>
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

        <form:form cssClass="f" method="POST" action="${contextPath}/student/create" modelAttribute="studentForm" class="form-signin">
            <h2 class="form-signin-heading">${studentForm.id != null ? 'Edit' : 'Create'} student</h2>

            <form:hidden path="id" />

            <%--NAME--%>
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Student name:
                    <form:input type="text" path="name" class="form-control"
                                autofocus="true"/>
                    <form:errors path="name"/>
                </div>
            </spring:bind>

            <%--SURNAME--%>
            <spring:bind path="surname">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Student surname:
                    <form:input type="text" path="surname" class="form-control"/>
                    <form:errors path="surname"/>
                </div>
            </spring:bind>

            <%--Address--%>
            <spring:bind path="address">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Address:
                    <form:input type="text" path="address" class="form-control"/>
                    <form:errors path="address"/>
                </div>
            </spring:bind>

            <%--Sex--%>
            <spring:bind path="sex">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Sex:
                    <form:select path="sex" cssClass="form-control">
                        <form:options items="${sexnEnum}"/>
                    </form:select>
                </div>
            </spring:bind>

            <%--Birth_date--%>
            <spring:bind path="birthDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Birth date:
                    <form:input type="date" path="birthDate" class="form-control"/>
                    <form:errors path="birthDate"/>
                </div>
            </spring:bind>

            <%--Birth_place--%>
            <spring:bind path="birthPlace">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Birth place:
                    <form:input type="text" path="birthPlace" class="form-control"/>
                    <form:errors path="birthPlace"/>
                </div>
            </spring:bind>

            <%--Birth_place--%>
            <spring:bind path="telephoneNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Telephone Number:
                    <form:input type="text" path="telephoneNumber" class="form-control"/>
                    <form:errors path="telephoneNumber"/>
                </div>
            </spring:bind>

            <%--BOOK_NUMBER--%>
            <spring:bind path="bookNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Book number:
                    <form:input type="text" path="bookNumber" class="form-control"/>
                    <form:errors path="bookNumber"/>
                </div>
            </spring:bind>

            <%--LAST GROUP JOIN DATE--%>
            <spring:bind path="groupPuttingDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    Last group putting date: <br>
                    <form:input type="date" path="groupPuttingDate" class="form-control"/>
                    <form:errors path="groupPuttingDate"/>
                </div>
            </spring:bind>

            <%--NOTE--%>
            <spring:bind path="note">
                <div class="form-group ${status.error ? 'has-error' : ''}">  Note about student:
                    <form:textarea type="text" path="note" class="form-control"/>
                    <form:errors path="note"/>
                </div>
            </spring:bind>

            <button class="but" type="submit">Submit</button>
        </form:form>
    </div>

    <script src="${contextPath}/resources/js/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
