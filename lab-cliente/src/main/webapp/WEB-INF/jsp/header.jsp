<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header" style="font: 8px; color: white; padding: 12px 0 0 0; text-align: center;">
				Cadastro de Cliente - Faculdades Alfa - Trabalho para Gest�o de Configura��o e mudan�a de Software
			</div>
		</div>
	</nav>
	
	
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap/js/moment.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
	<script type="text/javascript" src="js/labcliente.js"></script>
	
</body>