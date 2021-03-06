<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<body>

	<jsp:include page="header.jsp" />

	<h1>Listagem de Clientes</h1>

	<div class="containerlista">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">�</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<div class="form-group">
			<button type="button" id="buttonInsert" class="btn btn-success"
				onclick="location.href='cadastroCliente'">
				<span class="glyphicon glyphicon-plus-sign"></span> Inserir Cliente
			</button>
		</div>
		<div>
			<table id="tableClient" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="col-sm-3" data-field="nome">Nome</th>
						<th class="col-sm-3" data-field="nome">CPF / CNPJ</th>
						<th class="col-sm-2" data-field="tipoPessoa">Tipo Pessoa</th>
						<th class="col-sm-2" data-field="telefone">Telefone</th>
						<th class="col-sm-2" data-field="cidade">Cidade</th>
						<th class="col-sm-1" data-field="estado">UF</th>
					</tr>
				</thead>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.cpfCnpj}</td>
						<td>${cliente.tipoPessoa}</td>
						<td>${cliente.telefone.fixo}</td>
						<td>${cliente.endereco.cidade}</td>
						<td>${cliente.endereco.uf}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>