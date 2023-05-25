<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>
            <div class="container">

                <div class="row">
                    <img src="${pageContext.request.contextPath}/images/carportFrontpagePicture.png"/>
                </div>
                <div class="row">
                    <br><br>
                </div>

                <div class="row mb-4">
                    <div class="col d-flex justify-content-around">
                        <br><br>
                        <h2>Log ind eller opret en bruger  for at bestille din egen skræddersyede carport</h2>
                    </div>
                    <div class="col d-flex justify-content-around">
                        <form action="login.jsp">
                            <input type="submit" value="Log ind" class="frontbutton">
                        </form>
                        <form action="signup.jsp">
                            <input type="submit" value="Opret bruger" class="frontbutton">
                        </form>
                    </div>
                </div>

            </div>
    </jsp:body>

</t:pagetemplate>