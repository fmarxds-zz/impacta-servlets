<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Sistema</title>
</head>
<body>
	<header>
		<h2>Realize o login no sistema</h2>
	</header>
	<div class="container">
		<div class="form-horizontal">
			<form action="login" method="POST">

				<div>
					<h2 style="color: red;">${param.erro}</h2>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="txtUsuario">Usuário:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="txtUsuario" name="txtUsuario" placeholder="Insira seu usuário" required />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="txtSenha">Senha:</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="txtSenha" name="txtSenha" placeholder="Insira sua senha" required />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-5"></div>
					<input type="submit" class="btn btn-info" value="ACESSAR" />
				</div>

			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>