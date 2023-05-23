<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h1>Din carport er nu bestilt!</h1>

        <form action="Welcome"  method="get">
            <input type="submit" value="Startside">
        </form>
        <br>
        <form action="ViewOrders" method="get">
            <input type="submit" value="Mine bestillinger">
        </form>



    </jsp:body>

</t:pagetemplate>