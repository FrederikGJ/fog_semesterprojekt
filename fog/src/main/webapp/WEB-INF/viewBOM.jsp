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
                <h1>Her er din stykliste ${sessionScope.user.username}</h1>
            </div>
        </div>

        <div class="row text-center mt-5 mb-5">
            <div class="col-sm-12 col-md-12 col-lg-12">
                <h2>Stykliste</h2>
                <form action="viewbom" method="post">
                    <div class="table-responsive">
                        <table class="table table-bordered mt-4">
                            <thead>
                            </thead>
                            <thead>
                            <tr>
                                <th scope="col">Antal</th>
                                <th scope="col">Vare ID</th>
                                <th scope="col">Beskrivelse</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="BOM" items="${sessionScope.bomArrayList}">
                            <tr>
                                <td>${BOM.quantity}</td>
                                <td>${BOM.idMaterials}</td>
                                <td>${BOM.descriptionOfUSe}</td>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>
