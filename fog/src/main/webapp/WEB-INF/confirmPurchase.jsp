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

        <h1>Din carport er nu købt!</h1>
        <h2>Se din færdige ordre på siden 'Mine bestillinger'</h2>

        <form action="welcome.jsp"  method="get">
            <input type="submit" value="Startside" class="frontbutton">
        </form>
        <br>
        <form action="viewOrders.jsp" method="get">
            <input type="submit" value="Mine bestillinger" class="frontbutton">
        </form>



    </jsp:body>

</t:pagetemplate>