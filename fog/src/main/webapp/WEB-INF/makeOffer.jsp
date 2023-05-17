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
            <div class="col-6">
                <h2>Ordre info</h2>
                <table class="table mt-4">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">IDorders</th>
                            <td>${sessionScope.idOrders}<td>
                        </tr>
                        <tr>
                            <th scope="row">Username</th>
                            <td>${sessionScope.ongoingOrder.username}</td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td>${sessionScope.ongoingOrder.orderStatus}<td>
                        </tr>
                    </tbody>
                    <thead class="thead-light">
                        <tr class="table-secondary">
                            <th scope="row">Kundens udfyldte formular</th>
                            <th></th>
                            <th></th>
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
                            <td>${sessionScope.ongoingOrder.comments}<td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-6">
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
                                    <td>${BOM.quantity}</td>
                                    <td>${BOM.descriptionOfUse}</td>
                                    <td>${BOM.idMaterials}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col-12 text-center mt-4">
                <h2>Lav tilbud</h2>
                <table class="table table-bordered mt-4">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">.</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>x</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>xx</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>xxx</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>