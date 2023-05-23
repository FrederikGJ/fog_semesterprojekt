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


      <h1>Velkommen ${sessionScope.user.username}</h1>

      <form action="viewinventory" method="post">
          <input type="submit" value="Se alt inventar" class="frontbutton">
      </form>
      <br><br>

      <form action="viewrequests" method="post">
          <input type="submit" value="Se alle ordre"class="frontbutton">
      </form>






      <c:if test="${sessionScope.user == null}">
      <p>You are not logged in yet. You can do it here: <a
              href="../login.jsp">Login</a></p>
    </c:if>


  </jsp:body>

</t:pagetemplate>