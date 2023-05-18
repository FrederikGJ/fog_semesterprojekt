<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>


        <div class="row col-12 mb-4">
            <h1>Oversigt over ordre for ${sessionScope.user.username}</h1>
        </div>

        <div class="row">
            <div class="col-6">
                <h3>Afventer: </h3>
                <form method="get">
                    <table>
                        <tr>
                            <th>OrdreID</th>
                            <th>Længde</th>
                            <th>Bredde</th>
                            <th>Bemærkninger</th>
                            <th>Fuld pris</th>
                        </tr>

                        <c:forEach var="orders" items="${sessionScope.newOrders}">
                            <c:if test="${sessionScope.user.username == orders.username }">
                                <tr>
                                    <td>${orders.idOrders}</td>
                                    <td>${orders.length}</td>
                                    <td>${orders.width}</td>
                                    <td>${orders.comments}</td>
                                    <td>Ikke beregnet</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </form>
            </div>

        <div class="row">
            <div class="col-6">
                <h3>Tilbud: </h3>
                <form method="get">
                    <table>
                        <tr>
                            <th>OrdreID</th>
                            <th>Længde</th>
                            <th>Bredde</th>
                            <th>Bemærkninger</th>
                            <th>Fuld pris</th>
                            <th>Svar</th>
                        </tr>

                        <c:forEach var="orders" items="${sessionScope.pendingOrders}">
                            <c:if test="${sessionScope.user.username == orders.username }">
                            <tr>
                                <td>${orders.idOrders}</td>
                                <td>${orders.length}</td>
                                <td>${orders.width}</td>
                                <td>${orders.comments}</td>
                                <td>${orders.totalPrice}</td>
                                <td>
                                    <form action="#">
                                        <input type="submit" value="Accepter" name="accept">
                                        <br><br>
                                        <input type="submit" value="Afvis" name="decline">
                                    </form>
                                </td>

                            </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>

            <div class="col-6">
                <h3>Afsluttede: </h3>
                <form method="get">
                    <table>
                        <tr>
                            <th>OrdreID</th>
                            <th>Længde</th>
                            <th>Bredde</th>
                            <th>Bemærkninger</th>
                            <th>Fuld pris</th>
                            <th>Stykliste</th>
                        </tr>

                        <c:forEach var="orders" items="${sessionScope.finishedOrders}">
                            <c:if test="${sessionScope.user.username == orders.username }">
                                <tr>
                                    <td>${orders.idOrders}</td>
                                    <td>${orders.length}</td>
                                    <td>${orders.width}</td>
                                    <td>${orders.comments}</td>
                                    <td>${orders.totalPrice}</td>
                                    <td>
                                        <form action="#">
                                            <input type="submit" value="Se styklisten">
                                        </form>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>





    </jsp:body>

</t:pagetemplate>