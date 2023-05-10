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
        <h1>Vælg mål på din carport</h1>
        <form action="MakeNewRequest" method="post">
            <label for="length">Vælg carportens længde:</label>
            <select name="length" id="length">
                <option value="#">Længde 1</option>
                <option value="#">Længde 2</option>
                <option value="#">Længde 3</option>
                <option value="#">Længde 4</option>
            </select>
            <label for="width">Vælg carportens bredde:</label>
            <select name="width" id="width">
                <option value="#">Bredde 1</option>
                <option value="#">Bredde 2</option>
                <option value="#">Bredde 3</option>
                <option value="#">Bredde 4</option>
            </select>
        </form>



    </jsp:body>

</t:pagetemplate>