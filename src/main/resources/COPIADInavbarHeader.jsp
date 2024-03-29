<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.candidatoDB.pw2.entity.CandidaturaUser"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/logoPag.png"
	style="border-radius: 10px">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homeuser.css">

<body>
	<header>
		<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse "
			style="background-color: #0072BC">
			<div class="position-sticky">
				<div class="list-group list-group-flush mx-3 mt-5" style="gap: 3rem">
					<a href="${pageContext.request.contextPath}/profilo/profilo.jsp"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"><i class="bi bi-person-circle"
						style="margin-right: 5px; font-size: 20px"></i><span>Profilo</span></a>
					<a href="#"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="bi bi-file-earmark-person"
						style="margin-right: 5px; font-size: 20px"></i><span>Curriculum</span></a>
					<a href="#"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="bi bi-search" style="margin-right: 5px; font-size: 20px"></i><span>Ricerca
							Posizioni</span></a> <a
						href="${pageContext.request.contextPath}/home/visualizzaCandidature.jsp"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="bi bi-check2-circle"
						style="margin-right: 5px; font-size: 20px"></i><span>Candidature
							Effettuate</span></a> --> <a
						href="${pageContext.request.contextPath}/logout"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="bi bi-box-arrow-right"
						style="margin-right: 5px; font-size: 20px"></i><span>Logout</span></a>
				</div>
			</div>
		</nav>
		<nav id="main-navbar"
			class="navbar navbar-expand-lg navbar-light bg-white fixed-top"
			style="background-color: white;">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
					aria-controls="sidebarMenu" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home/homeuser.jsp"> <img
					src="${pageContext.request.contextPath}/img/logoPagina.png"
					height="50" alt="" loading="lazy" />
				</a>
				<h1 style="text-align: center; margin-top: 10px">
					Ciao
					<%=request.getSession().getAttribute("nome")%></h1>
				<span> <a
					href="${pageContext.request.contextPath}/home/homeuser.jsp"><h1>
							<span style="float: right; font-family: Comic Sans MS">JOBHUNTER
								&thinsp;</span>
						</h1></a>
				</span>
			</div>
		</nav>

	</header>

</body>
</html>






