<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Add Donation</title>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>--%>
<%--    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="header.jsp" %>--%>





<%--<%@include file="footer.jsp" %>--%>
<%--<script src="<c:url value="resources/js/app.js"/>"></script>--%>
<%--</body>--%>
<%--</html>--%>

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
<%@include file="header.jsp" %>

<section>
    <section>
        <h4>Podsumowanie</h4>

        Ilosc: ${donation.quantity}<br />
        Kategorie: <br />
        Instytucja: ${donation.institution}<br />
        Ulica: ${donation.street}<br />
        Miasto: ${donation.city}<br />
        Kod Pocztowy: ${donation.zipCode}<br />
        Data podjecia: ${donation.pickUpDate}<br />
        Godzina Podjecia: ${donation.pickUpTime}<br />
        Komentarz: ${donation.pickUpComment}<br />


        <form action="/" method="get">
            <button name="subject" type="submit" value="">Dalej</button>
        </form>

    </section>
</section>




<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>