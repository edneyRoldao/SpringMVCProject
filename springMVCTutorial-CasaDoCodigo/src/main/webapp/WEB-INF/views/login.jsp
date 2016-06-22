<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>
	</head>
	<body>
		<header>
			<div class="jumbotron containerApp" style="width: 600px;">
				<div class="container">
					<h3>Sistema de Vedas de Livros</h3>
					<h5>Tutorial Spring MVC - livro da casa do código</h5>
				</div>
			</div>
		</header>
		<div class="container formLogin">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
				<h3 class="panel-title">Acesso ao Sistema</h3>
				</div>
				<div class="panel-body">
					<div class="cadastro-form">
						<form:form method="post" action="/springTutorialCasaDoCodigo/login">
							<security:csrfInput/>
							<div class="row" style="margin-bottom: 15px;margin-top: 20px">
								<div class="col-xs-12">
									<label for="element-1" class="sr-only">User Name</label>
									<input id="element-1" class="form-control" placeholder="informe o login"/>
								</div>
							</div>
							<div class="row" style="margin-bottom: 15px;">
								<div class="col-xs-12">
									<label for="element-2" class="sr-only">Password</label>
									<input id="element-2" class="form-control" placeholder="informe a senha"/>
								</div>
							</div>
							<div class="form-group" style="margin-top: 15px">
								<input type="submit" class="btn btn-primary" value="Login"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>			
		</div>		
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>