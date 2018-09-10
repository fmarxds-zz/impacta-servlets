<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Prestadores</title>
</head>
<body>
	<%@ include file="cabecalho.jsp"%>

	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-sm-6">
				<h3>Dados do Prestador</h3>
				<div class="form-horizontal">
					<form action="prestadores" method=POST>
						<!-- DOCUMENTO DO PRESTADOR -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="documentoPrestador">Documento:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="documentoPrestador" id="documentoPrestador" required pattern="[0-9]*" />
							</div>
						</div>
						<!-- NOME DO PRESTADOR -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="nomePrestador">Nome:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="nomePrestador" id="nomePrestador" required pattern="[A-Za-z]*" />
							</div>
						</div>
						<!-- EMAIL DO PRESTADOR -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="emailPrestador">Email:</label>
							<div class="col-sm-9">
								<input type="email" class="form-control" name="emailPrestador" id="emailPrestador" required />
							</div>
						</div>
						<!-- TELEFONE DO PRESTADOR -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="telefonePrestador">Telefone:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="telefonePrestador" id="telefonePrestador" required pattern="[0-9]*" />
							</div>
						</div>
						<!-- USUARIO DO PRESTADOR -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="usuarioPrestador">Usuario:</label>
							<div class="col-sm-9">
								<select class="form-control" name="usuarioPrestador" id="usuarioPrestador">
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
				<h3>Prestadores Cadastrador</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>DOCUMENTO</th>
							<th>NOME</th>
							<th>USUARIO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prestadoresList}" var="prestador">
							<tr>
								<td>${prestador.documento}</td>
								<td>${prestador.nome}</td>
								<td>${prestador.usuario.nome}</td>
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