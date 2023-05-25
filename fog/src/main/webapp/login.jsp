<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
            
    </jsp:attribute>

    <jsp:body>

        <div class="row text-center">
            <div class="col-12">
                <h1>Log ind</h1>
            </div>
        </div>

        <div class="row mt-4">
        </div>

        <div class="row text-center mt-5">
            <form action="login" method="post">
                <div class="col-12">
                    <label class="mr-3" for="username">Username: </label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div class="col-12 mt-4">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div class="col-12 mt-4">
                    <input type="submit"  value="Log in"/>
                </div>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>