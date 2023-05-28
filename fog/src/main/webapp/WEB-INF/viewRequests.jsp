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
                    <h1>Se alle ordre</h1>
               </div>
           </div>

           <div class="row text-center mt-2">
               <h3>${requestScope.msgDelete}</h3>
           </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h3>Nye forespørgsler: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tr>
                                    <th>Ordre ID</th>
                                    <th>Brugernavn</th>
                                    <th>Status</th>
                                    <th>Valg</th>
                                </tr>
                                <tbody>
                                    <c:forEach var="orders" items="${sessionScope.newOrders}">
                                        <tr>
                                            <td><button class="custom-btn" formaction="makeoffer" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                            <td>${orders.username}</td>
                                            <td>${orders.orderStatus}</td>
                                            <td><button class="custom-btn" formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h3>Igangværende: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tr>
                                    <th>Ordres ID</th>
                                    <th>Brugernavn</th>
                                    <th>Status</th>
                                    <th>Valg</th>
                                </tr>
                                <tbody>
                                <c:forEach var="orders" items="${sessionScope.pendingOrders}">
                                    <tr>
                                        <td><button class="custom-btn" formaction="pendingorders" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                        <td>${orders.username}</td>
                                        <td>${orders.orderStatus}</td>
                                        <td><button class="custom-btn" formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row mt-5 mb-5">
                <div class="col-12">
                    <h3>Afsluttede: </h3>
                    <form method="get">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tr>
                                    <th>Orders ID</th>
                                    <th>Brugernavn</th>
                                    <th>Status</th>
                                    <th>Valg</th>
                                </tr>
                                <tbody>
                                    <c:forEach var="orders" items="${sessionScope.finishedOrders}">
                                        <tr>
                                            <td><button class="custom-btn" formaction="finishedorders" formmethod="post" name="idOrders" value="${orders.idOrders}">${orders.idOrders}</button></td>
                                            <td>${orders.username}</td>
                                            <td>${orders.orderStatus}</td>
                                            <td><button class="custom-btn" formaction="deleteorders" formmethod="post" name="idOrdersD" value="${orders.idOrders}">Slet</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
       </div>

    </jsp:body>
</t:pagetemplate>