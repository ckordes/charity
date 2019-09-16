
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
    <h2>Dodaj instytucje</h2>
    <section>
        <a href="add" class="btn btn--without-border active">Dodaj Instytucje</a>
    </section>
</nav>

<nav class="container container--70">
    <h2>Zarzadzaj Instytucjami</h2>

    <c:forEach items="${allInstitutions}" var="institution">
        <a href = "edit/${institution.id}" class="btn btn--without-border active">Edytuj ${institution.name}</a>
        <a href="delete/${institution.id}" class="btn btn--without-border active">Usun ${institution.name}</a><br/>
    </c:forEach>

</nav>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


