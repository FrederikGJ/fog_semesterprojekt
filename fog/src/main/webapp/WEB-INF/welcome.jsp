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

            <div class="row mt-3">
                <div class="col-sm-12 col-md-12 col-lg-6 d-flex">
                    <h2>Velkommen ${sessionScope.user.username}. Nu kan du bestille din egen skræddersyede carport</h2>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-3 d-flex justify-content-center mt-2">
                    <form style="text-indent: -2em; margin-left: 20px;" action="makenewrequest" method="get">
                        <input type="submit" value="Bestil carport" class="frontbutton">
                    </form>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-3 d-flex justify-content-center mt-2">
                    <form style="text-indent: -1em; margin-right: 5px;" action="vieworders" method="get">
                        <input type="submit" value="Mine bestillinger" class="frontbutton">
                    </form>
                </div>
            </div>

            <div class="row mt-4 mb-4">
                <div class="col-sm-12 col-md-12 col-lg-6 justify-content-center">
                    <h5>
                        Hos os i Fog fokuserer vi på at alle kan få netop dén carport der passer deres behov. Indsæt målene og evt. særlige krav til din carport. Så klarer Fog resten!
                    </h5>
                    <p style="margin-top: 30px;">
                        Gør det nemt at lave-det-selv. Få byg-selv carporten leveret som komplet byggesæt med monteringsvejledning,
                        så kommer du både godt og hurtigt fra start. Selv for den erfarne handyman kan det være meget tidskrævende
                        at gå i gang med at designe og bygge en carport helt fra bunden. Med byg-selv carporte kan du tage udgangspunkt
                        i en række standardmodeller i træ, som kan leveres i forskellige længder og størrelser, med og uden skur,
                        fladt tag eller tag med rejsning. Har du herudover behov for en ekstra meter i bredden, ønsker du en anden
                        beklædning end standardmodellen, eller vil du have et redskabsskur med isolering, kan du få lavet et konkret
                        tilbud på en carport i nøjagtig de mål, du ønsker. Vi hjælper selvfølgelig med at dimensionere stolper, remme,
                        spær, så du får noget, som lever op til den gældende lovgivning.
                    </p>
                </div>
                <div style="margin-top: 5px;" class="col-sm-12 col-md-12 col-lg-6 text-center">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/images/carportExample.png"/>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>