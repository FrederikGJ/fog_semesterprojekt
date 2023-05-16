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
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">.</th>
                            <th scope="col" colspan="2">..</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">IDorders</th>
                            <td colspan="2">${sessionScope.idorders}<td>
                        </tr>
                        <tr>
                            <th scope="row">Username</th>
                            <td colspan="2">${sessionScope.ongoingOrder.username}</td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td colspan="2">${sessionScope.ongoingOrder.orderStatus}<td>
                        </tr>
                    </tbody>
                    <thead class="thead-light">
                        <tr class="table-secondary">
                            <th scope="col" colspan="2">Kundens udfyldte formular</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Længde</th>
                            <td colspan="2">${sessionScope.ongoingOrder.length}</td>
                        </tr>
                        <tr>
                            <th scope="row">Bredde</th>
                            <td colspan="2">${sessionScope.ongoingOrder.width}</td>
                        </tr>
                        <tr>
                            <th scope="row">Bemærkninger</th>
                            <td colspan="2">${sessionScope.ongoingOrder.comments}<td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-6 text-center">
                <h2>Stykliste</h2>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Quantity</th>
                        <th scope="col">Description</th>
                        <th scope="col">ID Materials</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="BOM" items="${sessionScope.listBOM}">
                        <tr>
                            <th scope="row">1</th>
                            <td>${BOM.quantity}</td>
                            <td>${BOM.descriptionOfUSe}</td>
                            <td>${BOM.idmaterials}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th scope="row">2</th>
                        <td>xx</td>
                        <td>xx</td>
                        <td>xx</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>xxx</td>
                        <td>xxx</td>
                        <td>xxx</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-12 text-center mt-4">
                <h2>Lav tilbud</h2>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">.</th>
                        <th scope="col">..</th>
                        <th scope="col">...</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>xx</td>
                        <td>xx</td>
                        <td>xx</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>xxx</td>
                        <td>xxx</td>
                        <td>xxx</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>