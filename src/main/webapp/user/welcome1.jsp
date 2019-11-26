<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DB Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/css/scrolling-nav.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">DB Admin</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-right" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" onclick="document.forms['logoutForm'].submit()">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="bg-primary text-white">
    <div class="container text-center">
        <h1>Welcome ${pageContext.request.userPrincipal.name} to DB Admin</h1>
        <p class="lead">A landing page for DB Admin</p>
    </div>
</header>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<section id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2>Available tables</h2>
                <p class="lead">All tables that you can edit:</p>
                <ul>
                    <li><a href="${contextPath}/queryP">Query page</a></li>
                    <li><a href="${contextPath}/person/all">Person page</a></li>
                    <li><a href="${contextPath}/student/all">Student page</a></li>
                    <li><a href="${contextPath}/student-group/all">Student-Group page</a></li>
                    <li><a href="${contextPath}/group/all">Group page</a></li>
                    <li><a href="${contextPath}/student-mark/all">Student-Mark page</a></li>
                    <li><a href="${contextPath}/mark/all">Mark page</a></li>
                    <li><a href="${contextPath}/teacher-plan/all">Teach Plan page</a></li>
                    <li><a href="${contextPath}/lesson-kind/all">Lesson Kind page</a></li>
                    <li><a href="${contextPath}/lesson/all">Lesson page</a></li>
                    <li><a href="${contextPath}/test-kind/all">Test Kind page</a></li>
                    <li><a href="${contextPath}/subject/all">Subject page</a></li>
                    <li><a href="${contextPath}/semester/all">Semester page</a></li>
                </ul>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Petro Prydorozhnyi 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="${contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="${contextPath}/resources/js/scrolling-nav.js"></script>

</body>

</html>
