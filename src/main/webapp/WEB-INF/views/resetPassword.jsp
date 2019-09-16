<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<%--    <header>--%>
<%--      <nav class="container container--70">--%>
<%--        <ul class="nav--actions">--%>
<%--          <li><a href="#">Zaloguj</a></li>--%>
<%--          <li class="highlighted"><a href="#">Załóż konto</a></li>--%>
<%--        </ul>--%>

<%--        <ul>--%>
<%--          <li><a href="index.html" class="btn btn--without-border active">Start</a></li>--%>
<%--          <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--          <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>--%>
<%--          <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>--%>
<%--          <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>--%>
<%--        </ul>--%>
<%--      </nav>--%>
<%--    </header>--%>

<%@include file="header.jsp" %>

<section class="login-page">
    <h3>Podaj nowe haslo!</h3>
    <form method="post">
        <div class="form-group">
            <input name="password" placeholder="Now haslo"/>
            <%--          <input type="password" name="password" placeholder="Hasło" />--%>
        </div>
        <div class="form-group">
            <input name="password2" placeholder="Powtórz hasło"/>
            <%--          <input type="password" name="password2" placeholder="Powtórz hasło" />--%>
        </div>
        <button class="btn" type="submit">Resetuj haslo</button>
    </form>

</section>

<%@include file="footer.jsp" %>

</body>
</html>