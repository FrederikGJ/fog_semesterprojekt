<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><jsp:invoke fragment="header"/></title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light py-0">
                <div class="container" style="background-color: #002242">
                    <c:if test="${sessionScope.user == null }">
                        <a class="navbar-brand" href="index.jsp">
                            <img src="${pageContext.request.contextPath}/images/fogLogo.png" width="100px;" class="img-fluid"/>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">
                            <img src="${pageContext.request.contextPath}/images/fogLogo.png" width="100px;" class="img-fluid"/>
                        </a>
                    </c:if>


                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <c:if test="${sessionScope.user == null }">
                                <a style="font-family: Tahoma; font-weight: bold;color: white;" class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Log ind</a>
                            </c:if>
                            <c:if test="${sessionScope.user != null}">
                                <a style="font-family: Tahoma; font-weight: bold;color: white;" class="nav-item nav-link" href="${pageContext.request.contextPath}/makenewrequest">Bestil carport</a>
                                <a style="font-family: Tahoma; font-weight: bold;color: white;"class="nav-item nav-link" href="${pageContext.request.contextPath}/vieworders">Mine bestillinger</a>
                                <a style="font-family: Tahoma; font-weight: bold;color: white;"class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log ud</a>
                                <p style="font-family: Tahoma; font-weight: bold;color: white;"class="nav-item nav-link" class="nav-item nav-link">${sessionScope.user.username}</p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </nav>
        </header>

        <div id="body" class="container" style="min-height: 480px;">
            <h1><jsp:invoke fragment="header"/></h1>
            <jsp:doBody/>
        </div>

    <!-- Footer -->
        <div class="container mb-0">
            <div class="row text-center mb-0">
                <hr/>
                <div class="col-4 mb-0">
                    Johannes Fog A/S&copy;
                </div>
                <div class="col-4 mb-0">
                    <p>Firskovvej 20 <br>
                        2800 Lyngby
                    </p>
                </div>
                <div class="col-4 mb-0">
                    CVR-nr. 16314439
                </div>
            </div>
        </div>


    <!-- Bootstrap Bundle with Popper -->
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
         </script>
    </body>
</html>