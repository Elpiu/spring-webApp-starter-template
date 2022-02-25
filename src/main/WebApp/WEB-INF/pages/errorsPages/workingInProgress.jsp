<%@taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isErrorPage="true" %>


<link href="resources/css/product.css" rel="stylesheet" type="text/css">
<link href="<c:url value="../../../resources/css/errorCss/error.css"/>" rel="stylesheet" type="text/css">

<z:layout pageTitle="Working in progress">


    <div>
        <h1 class="error-code">Pagina in costruzione ci stiamo lavorando!</h1>
    </div>


        <div class="objects">
            <img class="object_face_rocket" src="${pageContext.request.contextPath}/resources/img/workingInProgress/Working%20late-bro.png"
                 width="320px">
        </div>
        <div class="box_face">
            <img class="object_face" src="${pageContext.request.contextPath}/resources/img/workingInProgress/Working%20late-bro.png"
                 width="560px">
        </div>






</z:layout>