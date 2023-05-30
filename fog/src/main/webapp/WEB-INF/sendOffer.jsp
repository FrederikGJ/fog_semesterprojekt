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

            <div class="container">
                <div class="row text-center mt-5">
                    <div class="col-12">
                        <h1>Tilbuddet er nu sendt</h1>
                    </div>
                </div>

                <div class="row text-center mt-5">
                    <div class="col-12">
                        <form action="welcome" method="get">
                            <input type="submit" value="Startside" class="frontbutton">
                        </form>
                    </div>
                </div>
            </div>

    </jsp:body>
</t:pagetemplate>
