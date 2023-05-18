<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
Inventar
    </jsp:attribute>

    <jsp:attribute name="footer">
            Inventar
    </jsp:attribute>
    <jsp:body>
        <h3>Intast ny vare information og gem i invantar</h3>
        <form action="addtoinventory" method="post">
            <td>
                Navn: <input type="text" id="material_name" name="name"/>
                Pris: <input type="text" id="unitprice" name="unitPrice"/>
                Enhed: <input type="text" id="unit" name="unit"/>
                Beskrivelse:<input type="text" id="description" name="description"/>
                Længde: <input type="text" id="length" name="length"/>
                <input type="submit" value="Tilføj">
            </td>
                ${requestScope.msgAdd}
        </form>

        <h3>Inventar</h3>
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
                        <td>${materials.idMaterials}</td>
                        <td>${materials.name}</td>
                        <td>${materials.unitPrice}</td>
                        <td>${materials.unit}</td>
                        <td>${materials.description}</td>
                        <td>${materials.length}</td>
                        <td>
                            <button formaction="deleteinventory" formmethod="post" name="idMaterialsD"
                                    value="${materials.idMaterials}">Delete
                            </button>
                        </td>
                        <td>
                            <button formaction="editinventory" formmethod="post" name="idMaterials"
                                    value="${materials.idMaterials}">Edit
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </jsp:body>
</t:pagetemplate>
