<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Cadastro de usuário</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>	
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
		<div class="container formUser">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
				<h3 class="panel-title" style="text-align: center;font-weight: bold;">
					<span class="glyphicon glyphicon-user"></span>
					Cadastro de Novo Usuário
				</h3>
				</div>
				<div class="panel-body">
					<div class="cadastro-form">
						<form:form method="post" action="/usuario/efetivaCadastro" commandName="usuario">
							<security:csrfInput/>
							<div class="row" style="margin-bottom: 15px;margin-top: 20px">
								<div class="col-xs-12">
									<form:input path="name" id="element-1" class="form-control" placeholder="Infome seu nome"/>
								</div>
							</div>
							<div class="row" style="margin-bottom: 15px;margin-top: 15px">
								<div class="col-xs-12">
									<form:input path="login" id="element-2" class="form-control" placeholder="Infome um e-mail de usuário"/>
								</div>
							</div>
							<div class="row" style="margin-bottom: 15px;">
								<div class="col-xs-12">
									<form:password path="password" id="element-3" class="form-control" placeholder="Informe uma senha"/>
								</div>
							</div>
							<div class="form-group" style="margin-top: 15px">
								<input type="submit" class="btn btn-primary" value="Cadastrar"/>
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