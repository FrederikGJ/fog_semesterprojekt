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
                            <option value="400">400cm</option>
                            <option value="450">450cm</option>
                            <option value="500">500cm</option>
                            <option value="550">550cm</option>
                            <option value="600">600cm</option>
                        </select>
                    </div>
                    <div class="col-12 mt-4">
                        <label for="width">Vælg carportens bredde:</label>
                        <select name="width" id="width">
                            <option value="300">300cm</option>
                            <option value="350">350cm</option>
                            <option value="400">400cm</option>
                            <option value="450">450cm</option>
                            <option value="500">500cm</option>
                            <option value="550">550cm</option>
                            <option value="600">600cm</option>
                        </select>
                    </div>
                    <div class="col-12 mt-4">
                        <input type="text" value="Bemærkninger:" name="comment">
                    </div>
                    <div class="col-12 mt-4">
                        <input type="submit" value="Gå til kassen">
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>