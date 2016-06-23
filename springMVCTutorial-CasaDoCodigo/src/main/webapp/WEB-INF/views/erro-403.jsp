<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
		<header>
			<div class="jumbotron containerApp" style="width: 600px;">
				<div class="container">
					<h3>Acesso Negado !</h3>
					<h5>Voc� precisa estar logado como Administrador</h5>
				</div>
			</div>
		</header>
		
		<!-- Formulario login -->
		<%@ include file="../templates/form-login.jsp" %>
		
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>