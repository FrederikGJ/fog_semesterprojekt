<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        Se alle ordre
    </jsp:attribute>

    <jsp:body>


       <div class="row col-12 mb-4">
           <h1>Se alle ordre</h1>
       </div>

        <div class="row mt-5">
            <div class="col-12">
                <h3>Nye forespørgsler: </h3>
                <form method="get">
                    <table class="table table-hover">
                            ${requestScope.msgDelete}
                        <tr>
                            <th>IDorders</th>
                            <th>Username</th>
                            <th>Status</th>
                            <th>Slet</th>
                        </tr>
                        <tbody>
                            <c:forEach var="orders" items="${sessionScope.newOrders}">
                                <tr>
                                    <td><button formaction="makeoffer" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                    <td>${orders.username}</td>
                                    <td>${orders.orderStatus}</td>
                                    <td><button formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>

            <div class="col-12">
                <h3>Igangværende: </h3>
                <form method="get">
                    <table class="table table-hover">
                        <tr>
                            <th>IDorders</th>
                            <th>Username</th>
                            <th>Status</th>
                            <th>Slet</th>
                        </tr>
                        <tbody>
                        <c:forEach var="orders" items="${sessionScope.pendingOrders}">
                            <tr>
                                <td><button formaction="pendingorders" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                <td>${orders.username}</td>
                                <td>${orders.orderStatus}</td>
                                <td><button formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12">
                <h3>Afsluttede: </h3>
                <form method="get">
                    <table class="table table-hover">
                        <tr>
                            <th>IDorders</th>
                            <th>Username</th>
                            <th>Status</th>
                            <th>Slet</th>
                        </tr>
                        <tbody>
                            <c:forEach var="orders" items="${sessionScope.finishedOrders}">
                                <tr>
                                    <td><button formaction="finishedorders" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                    <td>${orders.username}</td>
                                    <td>${orders.orderStatus}</td>
                                    <td><button formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>