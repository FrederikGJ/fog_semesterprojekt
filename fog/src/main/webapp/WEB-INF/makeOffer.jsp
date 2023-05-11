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
            <div class="col-6 text-center">
                <h2>Ordre info</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">.</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">IDorders</th>
                        <td>${orders.idorders}</td>
                    </tr>
                    <tr>
                        <th scope="row">Username</th>
                        <td>Jacob</td>
                    </tr>
                    <tr>
                        <th scope="row">Status</th>
                        <td>Larry</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-6 text-center">
                <h2>Stykliste</h2>
                <table class="table">
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
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td>@twitter</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-12 text-center">
                <h2>Lav tilbud</h2>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>