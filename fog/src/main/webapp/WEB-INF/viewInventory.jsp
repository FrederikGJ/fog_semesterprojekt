<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container">
            <div class="row text-center mt-2">
                <h3>${requestScope.msgAdd}</h3>
                <h3>${requestScope.msgDelete}</h3>
                <h3>${requestScope.msgEdit}</h3>
            </div>

            <div class="row justify-content-center mt-5">
                <div class="col-sm-12 col-md-12 col-lg-5 text-center">
                    <h3>Indtast ny vare information og gem i inventar</h3>
                    <form action="addtoinventory" method="post">
                        <div class="table-responsive">
                            <table class="table table-bordered mt-4">
                                <thead></thead>
                                <tbody></tbody>
                                    <tr>
                                        <th scope="row">Navn: </th>
                                        <td><input class="mt-1" type="text" id="material_name" name="name"/></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Pris: </th>
                                        <td><input class="mt-1" type="number" id="unitprice" name="unitPrice"/></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Enhed: </th>
                                        <td><input class="mt-1" type="text" id="unit" name="unit"/></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Beskrivelse: </th>
                                        <td><input class="mt-1" type="text" id="description" name="description"/></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Længde:  </th>
                                        <td><input class="mt-1" type="number" id="length" name="length"/></td>
                                    </tr>
                                    <thead></thead>
                                    <tr>
                                         <th colspan="2"><input class="mt-2" type="submit" value="Tilføj"></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row text-center mt-5 mb-5">
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <form method="post">
                        <div class="table-responsive text-nowrap table-fixed">
                            <table class="table">
                                <tr>
                                    <th>Vare ID</th>
                                    <th>Navn</th>
                                    <th>Pris</th>
                                    <th>Enhed</th>
                                    <th>Beskrivelse</th>
                                    <th>Længde</th>
                                    <th>Valg</th>
                                </tr>
                                <c:forEach var="materials" items="${sessionScope.materialsList}">
                                    <tr>
                                        <form action="editinventory" method="post">
                                            <td>${materials.idMaterials}</td>
                                            <td><input style="width: 100px;" type="text" name="nameE" id="nameE" value="${materials.name}"></td>
                                            <td><input style="width: 70px;" type="number" name="unitPriceE" id="unitPriceE" value="${materials.unitPrice}"> kr</td>
                                            <td><input style="width: 50px;" type="text" name="unitE" id="unitE" value="${materials.unit}"> stk</td>
                                            <td><input style="width: 100px;" type="text" name="descriptionE" id="descriptionE" value="${materials.description}"></td>
                                            <td><input style="width: 50px;" type="number" name="lengthE" id="lengthE" value="${materials.length}"> cm</td>
                                            <td>
                                                <button class="custom-btn" type="submit" name="idMaterialsE" value="${materials.idMaterials}">Gem
                                                </button>
                                                <button class="custom-btn mt-2" formaction="deleteinventory" formmethod="post" name="idMaterialsD"
                                                        value="${materials.idMaterials}">Slet
                                                </button>
                                            </td>
                                        </form>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>
