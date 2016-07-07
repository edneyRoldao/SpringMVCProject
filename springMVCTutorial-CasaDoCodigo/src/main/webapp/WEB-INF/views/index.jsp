<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
		<header>
			<div class="jumbotron containerApp">
				<div class="container">
					<h2>Seja Bem Vindo ao Tutorial de Spring MVC 4</h2>
					<h6>Este projeto é todo escrito em Spring, além disso, ele não contém arquivos xml. É tudo programático.<br/>
						Este projeto é uma versão melhorada do apresentado pelo livro sobre spring MVC da casa do código pois eu<br/>
						apliquei Bootstrap em todo o frontEnd.						
					</h6>
				</div>
			</div>
		</header>
		<div class="container">
			<div class="bodyIndex">
				<h3 style="margin-bottom: 25px;">Lista de Assuntos abordados nesse projeto</h3>
				
				<security:authorize access="isAuthenticated()">
					<security:authentication property="principal" var="usuario"/>
					${usuario.name}
				</security:authorize>
				
				<ul>
					<li>Spring Framework</li>
					<li>Spring MVC</li>
					<li>Spring Data</li>
					<li>Spring Security</li>
					<li>Restful</li>
				</ul>
			</div>
		</div>
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>