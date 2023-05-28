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
                    <h1>Vælg mål på din carport</h1>
                </div>
            </div>

            <div class="row text-center mt-5">
                <form action="makenewrequest" method="post">
                    <div class="col-12">
                        <label for="length">Vælg carportens længde:</label>
                        <select name="length" id="length">
                            <option value="400">400 cm</option>
                            <option value="450">450 cm</option>
                            <option value="500">500 cm</option>
                            <option value="550">550 cm</option>
                            <option value="600">600 cm</option>
                        </select>
                    </div>
                    <div class="col-12 mt-4">
                        <label for="width">Vælg carportens bredde:</label>
                        <select name="width" id="width">
                            <option value="300">300 cm</option>
                            <option value="350">350 cm</option>
                            <option value="400">400 cm</option>
                            <option value="450">450 cm</option>
                            <option value="500">500 cm</option>
                            <option value="550">550 cm</option>
                            <option value="600">600 cm</option>
                        </select>
                    </div>
                    <div class="col-12 mt-4">
                        <input type="text" placeholder="Tilføj bemærkning" name="comment">
                    </div>
                    <div class="col-12 mt-4">
                        <input type="submit" value="Gå til kassen">
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>