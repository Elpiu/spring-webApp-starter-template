<%@ tag body-content="scriptless"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>


	<!-- Custom fonts for this template-->
	<link href="../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		  rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="../../resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="../../resources/css/iconecss.css" rel="stylesheet">


	<!--Bootstrap-->

    <!--
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="http://fonts.cdnfonts.com/css/playlist" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="<c:url value="../../resources/css/errorCss/layout.css"/>" rel="stylesheet" type="text/css">

	<link href="resources/css/product.css" rel="stylesheet" type="text/css">

	<link href="<c:url value="../../resources/css/errorCss/error.css"/>" rel="stylesheet" type="text/css">

	-->
	<title>${pageTitle}</title>
</head> 

<body>

	<c:choose>
		<c:when test="${utente==null}">
			<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/pages/GUIGestioneUtente/headerhomepage.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/pages/GUIGestioneUtente/header.jsp" />
		</c:otherwise>
	</c:choose>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://kit.fontawesome.com/442bbb4090.js" crossorigin="anonymous"></script>


	<!-- Navbar-->
	<main>

			<jsp:doBody />

	</main>


	<script>
	// When the user scrolls the page, execute myFunction
	window.onscroll = function() {myFunction()};

	// Get the navbar
	var navbar = document.getElementById("navbar");

	// Get the offset position of the navbar
	var sticky = navbar.offsetTop;

	// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
	function myFunction() {
	  if (window.pageYOffset >= sticky) {
	    navbar.classList.add("sticky")
	  } else {
	    navbar.classList.remove("sticky");
	  }
	}
	</script>
	<!-- Footer colors #2e2e2e   and #252525  -->

	<!-- Bootstrap core JavaScript-->
	<script src="../../resources/vendor/jquery/jquery.min.js"></script>
	<script src="../../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../../resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../../resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../../resources/js/demo/chart-area-demo.js"></script>
	<script src="../../resources/js/demo/chart-pie-demo.js"></script>

	<div class="footer">

	</div>
	<!-- Footer -->
</body>

</html>