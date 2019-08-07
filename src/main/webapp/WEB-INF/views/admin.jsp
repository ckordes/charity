
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="headerForm.jsp" %>

<nav class="container container--70">
    <section>
        <a href="/donation/" class="btn btn--without-border active">Strona z darowiznami</a>
    </section>




    <section>
        <a href="manageInstitutions" class="btn btn--without-border active">Zarzadzaj instytucjami</a>
    </section>
    <section>
        <a href="manageAdmins" class="btn btn--without-border active">Zarzadzaj Administratorami</a>
    </section>
    <section>
        <a href="manageUsers" class="btn btn--without-border active">Zarzadzaj Uzytkownikami</a>
    </section>
</nav>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


