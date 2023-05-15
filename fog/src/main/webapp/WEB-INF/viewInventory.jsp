<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: signekruselllarsen
  Date: 09/05/2023
  Time: 11.10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addtoinventory" method="post">

    <td>
        ${sessionScope.materialsList}
        <label>Tilføj vare:</label><br>
        Navn: <input type="text" id="material_name" name="name"/>
        Pris: <input type="text" id="unitprice" name="unitPrice"/>
        Enhed: <input type="text" id="unit" name="unit"/>
        Beskrivelse:<input type="text" id="description" name="description"/>
        Længde: <input type="text" id="length" name="length"/>
        <input type="submit" value="Tilføj">
    </td>


</form>


<form method="post">
    <table>
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
                    <a href="editInventory? id =${materials.idMaterials}">Rediger</a>
                    <a href="deleteInventory? id =${materials.idMaterials}">Slet</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>
