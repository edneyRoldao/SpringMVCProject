<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Erro na Compra</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>		
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>	
		<header>
			<div class="jumbotron containerApp">
				<div class="container">
					<h2>COMPRA NÃO AUTORIZADA</h2>
				</div>
			</div>
		</header>
		
		<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
			<h3 style="text-align: center;">Compra não aprovada por exceder o valor máxima de 500,00 reais por compra</h3>
		</div>
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>