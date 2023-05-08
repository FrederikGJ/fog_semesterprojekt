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
            <form action="SignUp" method="post">
                <label for="email" hidden>Username: </label>
                <input type="text" id="email" name="email" placeholder="Insert Email"/>
                <br/>
                <label for="password" hidden>Password: </label><br/>
                <input type="password" id="password" name="password" placeholder="Insert Password"/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-secondary fw-bold" style="width: 180px;" value="Log in"/>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>