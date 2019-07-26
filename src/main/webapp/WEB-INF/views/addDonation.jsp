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
    <form:form modelAttribute="donation" method="post">
        Ilosc: <form:input path="quantity" id="quantity"/><br />
        Kategorie: <form:checkboxes path="categories" items="${allCategories}" itemLabel="name" itemValue="id" multiple="true" id="categories"/><br/>
        Instytucja: <form:select path="institution" items="${allInstitutions}" itemLabel="name" itemValue="id" id="institution"/><br/>
        Ulica: <form:input path="street" id="street"/><br />
        Miasto: <form:input path="city" id="city"/><br/>
        Kod Pocztowy: <form:input path="zipCode" id="zipCode"/><br/>
        Data podjecia: <form:input path="pickUpDate" type="date" id="pickUpDate"/><br/>
        Godzina podjecia: <form:input path="pickUpTime" type="time" id="pickUpTime"/><br/>
        Komentarz: <form:textarea path="pickUpComment" id="pickUpComment"/><br/>
        <input type="submit" value="Zapisz">
    </form:form>
</section>


<%--<section>--%>
<%--    <h4>Podsumowanie</h4>--%>

<%--    Ilosc: <p id="quantity1"> </p>--%>
<%--    Kategorie: <p id="categories1"> </p>--%>
<%--    Instytucja: <p id="institution1"> </p>--%>
<%--    Ulica: <p id="street1"> </p>--%>
<%--    Miasto: <p id="city1"> </p>--%>
<%--    Kod Pocztowy: <p id="zipCode1"> </p>--%>
<%--    Data podjecia: <p id="pickUpDate1"> </p>--%>
<%--    Godzina Podjecia: <p id="pickUpTime1"> </p>--%>
<%--    Komentarz: <p id="pickUpComment1"> </p>--%>

<%--</section>--%>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>