<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <table>
            <tr>
                <td class="table-header">Carport</td>
                <td class="table-header"></td>
            </tr>

            <tr>
                <th>Længde</th>
                <td>${requestScope.length}</td>
            </tr>
            <tr>
                <th>Bredde</th>
                <td>${requestScope.width}</td>
            </tr>
            <caption>${requestScope.comment}</caption>
        </table>
        <form action="ConfirmCarport" method="post">
            <input type="number" hidden name="length" value="${requestScope.length}">
            <input type="number" hidden name="width" value="${requestScope.width}">
            <input type="text" hidden name="comment" value="${requestScope.comment}">
            <input type="submit" value="Aflæg ordre">
        </form>

    </jsp:body>

</t:pagetemplate>