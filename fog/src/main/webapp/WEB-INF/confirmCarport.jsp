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
                        <table style="margin: auto">
                            <tr>
                                <th colspan="2" class="table-header">Carport</th>
                            </tr>
                            <tr>
                                <th>Længde</th>
                                <td>${requestScope.length}</td>
                            </tr>
                            <tr>
                                <th>Bredde</th>
                                <td>${requestScope.width}</td>
                            </tr>
                            <caption>${requestScope.comment}</caption>
                        </table>
                    </div>
                </div>

                <div class="row text-center mt-5">
                    <div class="col-12">
                        <form action="confirmcarport" method="post">
                            <input type="number" hidden name="length" value="${requestScope.length}">
                            <input type="number" hidden name="width" value="${requestScope.width}">
                            <input type="text" hidden name="comment" value="${requestScope.comment}">
                            <input type="submit" value="Aflæg ordre">
                        </form>
                    </div>
                </div>
            </div>

    </jsp:body>
</t:pagetemplate>