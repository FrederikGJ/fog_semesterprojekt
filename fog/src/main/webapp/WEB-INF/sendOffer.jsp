<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        Tilbuddet er sendt
    </jsp:attribute>

    <jsp:body>

            <div class="row justify-content-center">
                <div class="col-lg-12 text-center">
                    <h1>Tilbuddet er nu sendt</h1>
                </div>
            </div>

    </jsp:body>

</t:pagetemplate>
