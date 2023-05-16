<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the logged in area
    </jsp:attribute>

  <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

  <jsp:body>



      <form action="viewinventory" method="post">
          <input style="color: white; background-color: indigo; border: solid 5px indigo; border-radius: 5px; text-decoration: none"
                 type="submit" value="Se alt inventar">
      </form>
      <br>
      <br>
      <br>
      <form action="viewrequests" method="post">
          <input type="submit" value="Se alle ordre">
      </form>



      <c:if test="${sessionScope.user == null}">
      <p>You are not logged in yet. You can do it here: <a
              href="../login.jsp">Login</a></p>
    </c:if>

  </jsp:body>

</t:pagetemplate>