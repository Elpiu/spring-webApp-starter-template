<%@taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isErrorPage="true" %>


<link href="resources/css/product.css" rel="stylesheet" type="text/css">
<link href="<c:url value="../../../resources/css/errorCss/error.css"/>" rel="stylesheet" type="text/css">

<z:layout pageTitle="ErrorPage">


    <h1 class="error-code" >Error Page</h1>
    <p class="error" >Application has encountered an error. Please contact support on ...</p>

    <h1>${errorMsg}</h1>

    <p class="error" >Failed URL: ${url}</p>
    <p class="error" >Exception:  ${exception.message} </p>
    <p class="error" >
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste}
        </c:forEach>
    </p>


    <form method="get" action="Home">
        <button class="btn btn-success mt-2">Go Back</button>
    </form>

    <div class="objects">
        <img class="object_face_rocket" src="${pageContext.request.contextPath}/resources/img/errorImg/triste.png"
             width="80px">

        <div class="box_face">
            <img class="object_face" src="${pageContext.request.contextPath}/resources/img/errorImg/triste.png"
                 width="140px">
        </div>


    </div>


</z:layout>