<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <h2>Dette er h2</h2>
        <h3>Dette er h3</h3>

        <p>Startcode for 2nd semester </p>

        <form action="#">
            <label for="fname">First name:</label> <br>
            <input type="text" id="fname" name="fname"><br><br>
            <label for="lname">Last name:</label> <br>
            <input type="text" id="lname" name="lname"><br><br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <button>Back</button>
        <button>Forward</button>
        <br><br>



        <table>
            <tr>
                <td class="table-header">Carport</td>
                <td class="table-header"></td>
            </tr>

            <tr>
                <th>Element</th>
                <td>Measure</td>
            </tr>
            <tr>
                <th>Element</th>
                <td>Measure</td>
            </tr>
            <caption>Bemærninger: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquam at culpa doloremque enim esse eveniet ex, exercitationem iure non nostrum numquam quis quod sequi sit tempora veniam voluptate, voluptates</caption>
        </table>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>