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
    <h2>Lista Dotacji</h2>
    <section>
        <div class="form-group">
            <c:forEach items="${donationList}" var="donation" varStatus="donationCount">
                ${donationCount.count}<br/>
               Odebrano: ${donation.donationStatus.pickedUp},<br/>
                Data odebrania: ${donation.donationStatus.pickedUpDate}<br/>
                <a href="displayDonation/${donation.id}">Wyswietl szczegoly.</a><br/>
                <br/>
            </c:forEach>
        </div>
    </section>
</nav>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


