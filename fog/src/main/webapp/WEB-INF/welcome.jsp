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
            <div class="row">
                <img src="${pageContext.request.contextPath}/images/carportFrontpagePicture.png"/>
            </div>
            <div class="row">
                <br><br>
            </div>
            <div class="row">
                <div class="col d-flex justify-content-around">
                    <br><br>
                        <h2>Velkommen ${sessionScope.user.username}. Nu kan du bestille din egen skræddersyede carport</h2>

                </div>
                <div class="col d-flex justify-content-around">

                        <form action="MakeNewRequest" method="get">
                            <input type="submit" value="Bestil carport" class="frontbutton">
                        </form>

                        <form action="ViewOrders" method="get">
                            <input type="submit" value="Mine bestillinger" class="frontbutton">
                        </form>
                </div>
            </div>
            <div class="row">
                <div class="col d-flex justify-content-center">
                    <h5>
                        Hos os i Fog fokuserer vi på at alle kan få netop dén carport der passer deres behov. Indsæt målene og evt. særlige krav til din carport. Så klarer Fog resten!
                    </h5>
                </div>
                <div class="col d-flex justify-content-center">
                </div>
            </div>
            <div class="row">
                <div class="col d-flex justify-content-center">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium consequatur delectus distinctio perferendis placeat, sapiente tempore. Aliquam, in, ipsa. Deserunt ducimus eveniet id illum ipsum maiores minima nobis, nulla obcaecati officia optio quia ratione veniam voluptas, voluptatibus. Ad, aliquam animi assumenda dicta dolorem dolorum expedita facere impedit inventore iste libero, magnam maxime molestias perferendis quam repudiandae rerum similique. Alias commodi consequuntur culpa distinctio dolorem doloremque eos eum expedita facilis fuga fugiat harum ipsam laborum maiores mollitia nam natus, nisi non numquam omnis pariatur porro quam qui quidem quo quod quos reiciendis rem, repellat reprehenderit similique sit sunt suscipit tempore totam unde vel! Aliquam atque consequatur cupiditate delectus deserunt dolorem earum ex expedita harum id laudantium, magnam molestias, nostrum odit pariatur placeat possimus praesentium quaerat quasi quidem ratione rem, repudiandae sint voluptate voluptatibus? Ad dolores doloribus ea et facilis harum iusto, laboriosam, laborum mollitia obcaecati omnis pariatur saepe sed sit ullam?.</p>

                </div>
                <div class="col-sm d-flex justify-content-center">
                    <img src="${pageContext.request.contextPath}/images/carportExample.png"/>

                </div>


            </div>
        </div>

    </jsp:body>

</t:pagetemplate>