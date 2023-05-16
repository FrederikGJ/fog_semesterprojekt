<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>
        <form method="get">
            <table>
                <tr>
                    <th>Idorders</th>
                    <th>Username</th>
                    <th>Price</th>
                </tr>

                <c:forEach var="orders" items="${requestScope.ordersList}">
                    <c:if test="${sessionScope.user.username == orders.username }">
                        <tr>
                            <td>${orders.idorders}</td>
                            <td>${orders.username}</td>
                        </tr>
                    </c:if>

                </c:forEach>
            </table>

        </form>


    </jsp:body>

</t:pagetemplate>