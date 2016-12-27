<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<h1>Cadastro</h1>
		
		<div class="starter-template">
			<form:form class="form-horizontal" method="post"
				modelAttribute="cliente" action="/clientes">

				<spring:bind path="nome">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Nome</label>
						<div class="col-sm-6">
							<form:input path="nome" type="text" class="form-control"
								id="nome" placeholder="Nome" />
							<form:errors path="nome" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="cpfCnpj">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">CPF / CNPJ</label>
						<div class="col-sm-4">
							<form:input path="cpfCnpj" type="number" class="form-control"
								id="cpfCnpj" placeholder="CPF / CNPJ" maxlength="14" />
							<form:errors path="cpfCnpj" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="tipoPessoa">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Tipo Pessoa</label>
						<div class="col-sm-4">
							<form:select path="tipoPessoa" class="form-control">
								<form:options items="${tiposPessoa}" />
							</form:select>
							<form:errors path="tipoPessoa" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<div class="form-group">
					<div class="col-sm-10">
						<button type="submit" class="btn-lg btn-primary pull-left">Salvar</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>

</html>