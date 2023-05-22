<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
            Inventar
    </jsp:attribute>
    <jsp:body>
        <h3>Intast ny vare information og gem i invantar</h3>
        <form action="addtoinventory" method="post">
            <table>
                <td>
                    Navn: <input type="text" id="material_name" name="name"/>
                    Pris: <input type="number" id="unitprice" name="unitPrice"/>
                    Enhed: <input type="text" id="unit" name="unit"/>
                    Beskrivelse:<input type="text" id="description" name="description"/>
                    Længde: <input type="number" id="length" name="length"/>
                    <input type="submit" value="Tilføj">
                </td>
                    ${requestScope.msgAdd}
            </table>
        </form>


        <form method="post">
            <table>
                    ${requestScope.msgDelete}${requestScope.msgEdit}
                <tr>
                    <th>Vare ID</th>
                    <th>Navn</th>
                    <th>Enheds Pris</th>
                    <th>Enhed</th>
                    <th>Beskrivelse</th>
                    <th>Længde</th>
                </tr>
                <c:forEach var="materials" items="${sessionScope.materialsList}">
                    <tr>
                        <form action="editinventory" method="post">
                            <td>${materials.idMaterials}</td>
                            <td><input type="text" name="nameE" id="nameE" value="${materials.name}"></td>
                            <td><input type="number" name="unitPriceE" id="unitPriceE" value="${materials.unitPrice}"></td>
                            <td><input type="text" name="unitE" id="unitE" value="${materials.unit}"></td>
                            <td><input type="text" name="descriptionE" id="descriptionE" value="${materials.description}"></td>
                            <td><input type="number" name="lengthE" id="lengthE" value="${materials.length}"></td>
                            <td>
                                <button type="submit" name="idMaterialsE" value="${materials.idMaterials}">Gem ændring
                                </button>
                            </td>
                        </form>
                        <td>
                            <button formaction="deleteinventory" formmethod="post" name="idMaterialsD"
                                    value="${materials.idMaterials}">Slet
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </form>
    </jsp:body>
</t:pagetemplate>
