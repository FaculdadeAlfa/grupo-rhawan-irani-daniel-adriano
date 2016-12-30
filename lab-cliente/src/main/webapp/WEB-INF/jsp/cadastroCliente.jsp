<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<body>

	<jsp:include page="header.jsp" />

	<h1>Cadastro</h1>

	<div class="containerCadastro">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		
		<button type="button" id="buttonSearch" class="btn btn-info" onclick="location.href='/'">
				<span class="glyphicon glyphicon-search"></span> Pesquisar Clientes
			</button><br><br>

		<div class="starter-template">
			<form:form class="form-horizontal" method="post"
				modelAttribute="cliente" action="/clientes">

				<spring:bind path="nome">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Nome</label>
						<div class="col-sm-4">
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

				<br />
				<h2>Endereço</h2>
				<spring:bind path="endereco.cep">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">CEP</label>
						<div class="col-sm-4">
							<form:input path="endereco.cep" type="number"
								class="form-control" id="cep" placeholder="CEP" maxlength="8" />
							<form:errors path="endereco.cep" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="endereco.bairro">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Bairro</label>
						<div class="col-sm-4">
							<form:input path="endereco.bairro" type="text"
								class="form-control" id="bairro" placeholder="Bairro" />
							<form:errors path="endereco.bairro" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="endereco.logradouro">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Logradouro</label>
						<div class="col-sm-4">
							<form:input path="endereco.logradouro" type="text"
								class="form-control" id="logradouro" placeholder="Logradouro" />
							<form:errors path="endereco.logradouro" class="control-label" />
						</div>
						<label class="col-sm-1 control-label">Número</label>
						<div class="col-sm-2">
							<form:input path="endereco.numero" type="number"
								class="form-control" id="numero" placeholder="Número" />
							<form:errors path="endereco.numero" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="endereco.cidade">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Cidade</label>
						<div class="col-sm-4">
							<form:input path="endereco.cidade" type="text"
								class="form-control" id="cidade" placeholder="Cidade" />
							<form:errors path="endereco.cidade" class="control-label" />
						</div>
						<label class="col-sm-1 control-label">UF</label>
						<div class="col-sm-2">
							<form:select path="endereco.uf" class="form-control">
								<form:options items="${ufs}" />
							</form:select>
							<form:errors path="endereco.uf" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<br />
				<h2>Telefone</h2>
				<spring:bind path="telefone.fixo">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Telefone Fixo</label>
						<div class="col-sm-3">
							<form:input path="telefone.fixo" type="number"
								class="form-control" id="telefoneFixo"
								placeholder="Telefone Fixo" />
							<form:errors path="telefone.fixo" class="control-label" />
						</div>

						<label class="col-sm-2 control-label">Telefone Celular</label>
						<div class="col-sm-3">
							<form:input path="telefone.celular" type="number"
								class="form-control" id="telefoneCelular"
								placeholder="Telefone Celular" />
							<form:errors path="telefone.celular" class="control-label" />
						</div>
					</div>
				</spring:bind><br><br>

				<div class="form-group" style="text-align: center; padding: 0 0 0 35%">
						<button type="submit" class="btn-lg btn-primary pull-left" style="width: 200px; text-align: center;">Salvar</button>
				</div>
			</form:form>
		</div>
	</div>

</body>

</html>