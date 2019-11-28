<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
    <meta name = "author" content="Yaroslav Zemlianko">
    <meta name = "description" content="The best teams, football players and coaches from statistic and my opinion">
    <meta name = "keywords" content="football, players, best, team, coach, statistic">
    <link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
    <style type="text/css">
        body {margin: 0; background: blue;}
    </style>
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
<div class = "textmenu">
    <h1 class = "h1" align = center><font color = purple face = "agency fb"><a name = "main">Tables</a></font></h1>
    <table border="0" class="tablephoto">
        <tr>
            <td align = center><figure><a class = "flink" href="${contextPath}/person/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/person.jpg');">
                <figcaption>Person</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/person-privilege/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/personprivilege.jpg');">
                <figcaption>Person_Privilege</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/privilege/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/privilege.jpg');">
                <figcaption>Privilege</figcaption></a></figure></td>
        </tr>
    </table>

    <table border="0" class="tablephoto">
        <tr>
            <td align = center><figure><a class = "flink" href="${contextPath}/student/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/student.jpg');">
                <figcaption>Student</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/student-group/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/student-group.jpg');">
                <figcaption>Student_Group</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/group/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/group.jpg');">
                <figcaption>Group</figcaption></a></figure></td>
        </tr>
    </table>

    <table border="0" class="tablephoto">
        <tr>
            <td align = center><figure><a class = "flink" href="${contextPath}/violation/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/violation.jpg');">
                <figcaption>Violation</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/violation-kind/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/violation-kind.jpg');">
                <figcaption>Violation_Kind</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/order/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/order.jpg');">
                <figcaption>Order</figcaption></a></figure></td>
        </tr>
    </table>

    <table border="0" class="tablephoto">
        <tr>
            <td align = center><figure><a class = "flink" href="${contextPath}/speciality/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/speciality.jpg');">
                <figcaption>Speciality</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/cafedra/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/cafedra.jpg');">
                <figcaption>Cafedra</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/order-kind/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/order-kind.jpg');">
                <figcaption>Order_Kind</figcaption></a></figure></td>
        </tr>
    </table>

    <table border="0" class="tablephoto" style="border-bottom: 2px solid darkorange;">
        <tr>
            <td align = center><figure><a class = "flink" href="${contextPath}/mark/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/mark.jpg');">
                <figcaption>Mark</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/student-mark/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/student-mark.jpg');">
                <figcaption>Student_Mark</figcaption></a></figure></td>
            <td align = center><figure><a class = "flink" href="${contextPath}/teacher-plan/all">
                <img class="new1" style="background-image: url('${contextPath}/user/img/teacher-plan.jpg');">
                <figcaption>Teacher-Plan</figcaption></a></figure></td>
        </tr>
    </table>
</div>
<div class = "lastmenu">
    <p class = "mail" align=center>Developer`s name: Yaroslav Zemlianko<br>Write to developer`s email: <A class = "lmail" href = mailto:zema290613@gmail.com>zema290613@gmail.com</A></p>
</div>
</body>
</html>
