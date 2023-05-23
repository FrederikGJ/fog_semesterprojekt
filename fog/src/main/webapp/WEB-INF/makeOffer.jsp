<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        Ordre info og lav tilbud
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-md-12 col-lg-6">
                <h2>Ordre info</h2>
                <table class="table table-bordered mt-4">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">IDorders</th>
                            <td>${sessionScope.idOrders}</td>
                        </tr>
                        <tr>
                            <th scope="row">Username</th>
                            <td>${sessionScope.ongoingOrder.username}</td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td>${sessionScope.ongoingOrder.orderStatus}</td>
                        </tr>
                    </tbody>
                    <thead class="thead-light">
                        <tr class="table-secondary">
                            <th scope="row" colspan="2">Kundens udfyldte formular</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Længde</th>
                            <td>${sessionScope.ongoingOrder.length}</td>
                        </tr>
                        <tr>
                            <th scope="row">Bredde</th>
                            <td>${sessionScope.ongoingOrder.width}</td>
                        </tr>
                        <tr>
                            <th scope="row">Bemærkninger</th>
                            <td>${sessionScope.ongoingOrder.comments}</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-md-12 col-lg-6">
                <h2>Stykliste</h2>
                <form method="post">
                    <table class="table table-bordered mt-4">
                        <thead>
                        </thead>
                        <thead>
                            <tr>
                                <th scope="col">Quantity</th>
                                <th scope="col">Description</th>
                                <th scope="col">ID Materials</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="BOM" items="${sessionScope.bomArrayList}">
                                <tr>
                                    <td>${BOM.idOrders}</td>
                                    <td>${BOM.quantity}</td>
                                    <td>${BOM.descriptionOfUSe}</td>
                                    <td>${BOM.idMaterials}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <thead>
                                </thead>
                                <th scope="row" colspan="2">Samlet kostpris</th>
                                <td>${sessionScope.totalBomPrice}</td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-5 text-center mt-4">
                <h2>Lav tilbud</h2>
                <table class="table table-bordered mt-4">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Dækningsgrad</th>
                            <td>${sessionScope.operationMargin}</td>
                        </tr>
                        <tr>
                            <th scope="row">Pris uden moms</th>
                            <td>${sessionScope.salespriceTaxFree}</td>
                        </tr>
                        <tr>
                            <th scope="row">Pris med moms</th>
                            <td>${sessionScope.salesprice}</td>
                        </tr>
                        <tr>
                            <th scope="row">Prisændring</th>
                            <td>${sessionScope.priceChange}</td>
                        </tr>
                        <tr>
                            <th scope="row">Prisforslag ved salg</th>
                            <td>
                                <form method="post">
                                    <label for="${sessionScope.salesprice}"></label>
                                    <input type="hidden" name="idOrders" value="${sessionScope.idOrders}"/>
                                    <input class="mt-2" type="number" class="form-control text-center" id="${sessionScope.salesprice}" name="salesprice" value="${sessionScope.salesprice}"/>
                                    <button class="mt-2" formaction="makeoffer" >Opdater</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <thead>
                            </thead>
                            <th scope="row" colspan="2">Send tilbud</th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>