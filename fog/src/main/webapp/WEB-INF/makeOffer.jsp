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
                <div class="col-sm-12 col-md-12 col-lg-6">
                    <h2>Ordre info</h2>
                    <div class="table-responsive">
                        <table class="table table-bordered mt-4">
                            <thead>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Ordre ID</th>
                                    <td>${sessionScope.idOrders}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Brugernavn</th>
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
                </div>
                <div class="col-sm-12 col-md-12 col-lg-6">
                    <h2>Stykliste</h2>
                    <form method="post">
                        <div class="table-responsive">
                            <table class="table table-bordered mt-4">
                                <thead>
                                </thead>
                                <thead>
                                    <tr>
                                        <th scope="col">Antal</th>
                                        <th scope="col">Beskrivelse</th>
                                        <th scope="col">Vare ID</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="BOM" items="${sessionScope.bomArrayList}">
                                        <tr>
                                            <td>${BOM.quantity}</td>
                                            <td>${BOM.descriptionOfUSe}</td>
                                            <td>${BOM.idMaterials}</td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <thead>
                                        </thead>
                                        <th scope="row" colspan="2">Samlet kostpris</th>
                                        <td>${sessionScope.totalBomPrice} kr</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row justify-content-center mt-5 mb-5">
                <div class="col-sm-12 col-md-12 col-lg-5 text-center">
                    <h2>Lav tilbud</h2>
                    <form method="post">
                        <div class="table-responsive">
                            <table class="table table-bordered mt-4">
                                <thead>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Dækningsgrad</th>
                                        <td>${sessionScope.operationMargin} %</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Pris uden moms</th>
                                        <td>${sessionScope.salespriceTaxFree} kr</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Pris med moms</th>
                                        <td>${sessionScope.salesprice} kr</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Prisændring</th>
                                        <td>${sessionScope.priceChange} kr</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Prisforslag ved salg</th>
                                        <td>
                                            <label for="${sessionScope.salesprice}"></label>
                                            <input type="hidden" name="idOrders" value="${sessionScope.idOrders}" />
                                            <input class="mt-2" type="number" class="form-control text-center" id="${sessionScope.salesprice}" name="salesprice" value="${sessionScope.salesprice}"/>
                                            <button class="custom-btn mt-2" type="submit" formaction="makeoffer"/>Opdater</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Bemærkninger</th>
                                        <td>
                                            <label for="${requestScope.adminComment}"></label>
                                            <input type="text" value="Fog bemærkninger: " name="adminComment"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <thead>
                                        </thead>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <th><button class="custom-btn" formaction="sendoffer" type="submit">Send tilbud</button></th>
                    </form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>