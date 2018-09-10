<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Clientes</title>
</head>
<body>
	<%@ include file="cabecalho.jsp"%>

	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-sm-6">
				<h3>Dados do Cliente</h3>
				<div class="form-horizontal">
					<form action="clientes" method="POST">
						<!-- NOME DO CLIENTE -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="nomeCliente">Nome:</label>
							<div class="col-sm-9">
								<input type="text" name="nomeCliente" id="nomeCliente" class="form-control" required pattern="[A-Za-z]*" />
							</div>
						</div>
						<!-- EMAIL DO CLIENTE -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="emailCliente">Email:</label>
							<div class="col-sm-9">
								<input type="email" name="emailCliente" id="emailCliente" class="form-control" required />
							</div>
						</div>
						<!-- TELEFONE DO CLIENTE -->
						<div class="form-group">
							<label class="control-label col-sm-3 col-xs-3" for="telefoneCliente">Telefone:</label>
							<div class="col-sm-6 col-xs-9">
								<input type="text" name="telefoneCliente" id="telefoneCliente" class="form-control" required pattern="[0-9]*" />
							</div>
						</div>
						<!-- USUARIO DO CLIENTE -->
						<div class="form-group">
							<label class="control-label col-sm-3 col-xs-3" for="usuarioCliente">Usuário:</label>
							<div class="col-sm-6 col-xs-9">
								<select class="form-control" name="usuarioCliente" id="usuarioCliente">
									<c:forEach items="${usuariosList}" var="usuario">
										<option value="${usuario.nome}">${usuario.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<!-- BOTÃO ENVIAR -->
						<div class="form-group">
							<input type="submit" value="Cadastrar" class="btn btn-info" />
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-6">
				<h3>Lista de Clientes</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>NOME</th>
							<th>EMAIL</th>
							<th>TELEFONE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientesList}" var="cliente">
							<tr>
								<td>${cliente.idCliente}</td>
								<td>${cliente.nome}</td>
								<td>${cliente.email}</td>
								<td>${cliente.telefone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>