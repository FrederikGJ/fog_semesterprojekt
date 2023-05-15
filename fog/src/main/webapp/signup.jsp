<%--
  Created by IntelliJ IDEA.
  User: frederikj
  Date: 08/05/2023
  Time: 18.11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             SignUp
    </jsp:attribute>

    <jsp:attribute name="footer">
            SignUp
    </jsp:attribute>

    <jsp:body>

        <h3>You can sign up here</h3>


        <div class="text-center mt-5">
            <form action="/action_page.php" method="get">
                <label for="fname">First name:</label>
                <input type="text" id="fname" name="fname"><br><br>
                <label for="lname">Last name:</label>
                <input type="text" id="lname" name="lname"><br><br>
                <button type="submit">Submit</button>
                <button type="submit" formaction="/action_page2.php">Submit to another page</button>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>