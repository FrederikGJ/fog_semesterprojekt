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
<form method="post">
  <table>
    <tr>
      <th>Name</th>
      <th>UnitPrice</th>
      <th>Unit</th>
      <th>Description</th>
    </tr>

    <c:forEach var="materials" items="${requestScope.materialsList}">
      <tr>
        <td>${materials.idMaterials}</td>
        <td>${materials.name}</td>
        <td>${materials.unitPrice}</td>
        <td>${materials.unit}</td>
        <td>${materials.description}</td>

        <button formaction="addtoinventory" formmethod="post"
                value=""
        </button>


      </tr>
    </c:forEach>
  </table>

</form>

</body>
</html>
