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

        <div class="container">
            <div class="row text-center mt-5">
                <div class="col-12">
                <h1>Oversigt over ordre for ${sessionScope.user.username}</h1>
                </div>
            </div>

            <div class="row text-center mt-3">
                    <h3>${requestScope.msgDecline}</h3>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h3>Afventer: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table>
                                <tr>
                                    <th>Ordre ID</th>
                                    <th>Længde</th>
                                    <th>Bredde</th>
                                    <th>Bemærkninger</th>
                                    <th>Fuld pris</th>
                                </tr>
                                <c:forEach var="orders" items="${sessionScope.newOrders}">
                                    <c:if test="${sessionScope.user.username == orders.username }">
                                        <tr>
                                            <td>${orders.idOrders}</td>
                                            <td>${orders.length} cm</td>
                                            <td>${orders.width} cm</td>
                                            <td>${orders.comments}</td>
                                            <td>Afventer tilbud</td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </table>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h3>Tilbud: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table>
                                <tr>
                                    <th>Ordre ID</th>
                                    <th>Længde</th>
                                    <th>Bredde</th>
                                    <th>Bemærkninger</th>
                                    <th>Fuld pris</th>
                                    <th>Valg</th>
                                </tr>

                                <c:forEach var="orders" items="${sessionScope.pendingOrders}">
                                    <c:if test="${sessionScope.user.username == orders.username }">
                                        <tr>
                                            <form action="acceptcarport" method="post">
                                                <td>${orders.idOrders}</td>
                                                <td>${orders.length} cm</td>
                                                <td>${orders.width} cm</td>
                                                <td>${orders.comments}</td>
                                                <td>${orders.totalPrice} kr</td>
                                                <td>
                                                    <button class="custom-btn" formaction="acceptcarport" formmethod="post" value="${orders.idOrders}" name="idOrders">Accepter
                                                    </button>
                                                    <button class="custom-btn mt-2" formaction="declinecarport" formmethod="post" name="idOrdersD"
                                                            value="${orders.idOrders}">Afvis
                                                    </button>
                                                </td>
                                            </form>
                                        </tr>
                                        </c:if>
                                    </c:forEach>
                                </table
                            </div>
                        </form>
                    </div>
                </div>
             </div>

            <div class="row mt-5 mb-5">
                <div class="col-12">
                    <h3>Afsluttede: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table>
                                <tr>
                                    <th>Ordre ID</th>
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
                                            <td>${orders.length} cm</td>
                                            <td>${orders.width} cm</td>
                                            <td>${orders.comments}</td>
                                            <td>${orders.totalPrice} kr</td>
                                            <td><button class="custom-btn" formaction="viewbom" formmethod="post" name="idOrders" value="${orders.idOrders}">Se stykliste</button></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>