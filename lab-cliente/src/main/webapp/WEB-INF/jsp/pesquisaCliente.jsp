<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<body>

	<jsp:include page="header.jsp" />

	<div class="container">
	
		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
	
		<h1>Listagem de Clientes</h1>

		<div class="starter-template">
			<table>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td>${cliente.nome}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>

</html>