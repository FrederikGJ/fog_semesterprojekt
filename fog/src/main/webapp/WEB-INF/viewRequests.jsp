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

        <div class="row">
            <div class="col-6">
                <h3>Igangværende: </h3>
                <form method="get">
                    <table>
                        <tr>
                            <th>IDorders</th>
                            <th>Username</th>
                            <th>Status</th>
                        </tr>

                        <c:forEach var="orders" items="${sessionScope.ongoingOrders}">
                            <tr>
                                <td>${orders.idorders}</td>
                                <td>${orders.username}</td>
                                <td>${orders.orderStatus}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>

            <div class="col-6">
                <h3>Afsluttede: </h3>
                <form method="get">
                    <table>
                        <tr>
                            <th>IDorders</th>
                            <th>Username</th>
                            <th>Status</th>
                        </tr>

                        <c:forEach var="orders" items="${sessionScope.finishedOrders}">
                            <tr>
                                <td>${orders.idorders}</td>
                                <td>${orders.username}</td>
                                <td>${orders.orderStatus}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>