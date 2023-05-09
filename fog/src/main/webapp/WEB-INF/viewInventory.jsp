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
      <th>Username</th>
      <th>Credit</th>
      <th>Actions</th>
    </tr>

    <c:forEach var="user" items="${requestScope.userList}">
      <tr>
        <td>${user.username}</td>
        <td>${user.credit}</td>
        <td>
          <button formaction="insertamount" formmethod="post" name="username"
                  value="${user.username}">Insert amount
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>

</form>

</body>
</html>
