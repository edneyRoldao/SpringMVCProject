<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Home</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	    <!-- Bootstrap -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	    <link href="resources/css/bootstrap.min.css" rel="stylesheet"/>
	    <link href="resources/css/springTutorial.css" rel="stylesheet"/>
	</head>
	<body>
		<header>
			<div class="jumbotron headerIndex">
				<div class="container">
					<h2>Seja Bem ao Tutorial de Spring MVC 4</h2>
					<h6>Este projeto é todo escrito em Spring, além disso, ele não contém arquivos xml. É tudo programático.<br/>
						Este projeto é uma versão melhorada do apresentado pelo livro sobre spring MVC da casa do código pois eu<br/>
						apliquei Bootstrap em todo o frontEnd.						
					</h6>
				</div>
			</div>
		</header>
		
		<div class="container">
			<div class="indexBtn">
				<div style="float: left;">
					<a class="btn btn-primary" href="/springTutorialCasaDoCodigo/produto/lista">
						Pesquisar Produtos
					</a>
				</div>
				<div >
					<a class="btn btn-primary" href="/springTutorialCasaDoCodigo/produto/cadastro">
						Cadastrar Produtos
					</a>
				</div>			
			</div>
			<div style="margin-top: 30px;">
				<h3 style="text-align: center;">Lista de Assuntos abordados nesse projeto	</h3>
				<ul>
					<li>Spring Framework</li>
					<li>Spring MVC</li>
					<li>Spring Data</li>
					<li>Spring Security</li>
					<li>Rest</li>
				</ul>
			</div>
		</div>
		
		<footer class="footer" style="margin-top: 10px">
			<p>
				© 2016 - Developed by Edney Roldão &#160;&#160;
				<img src="resources/img/avatar.jpg"/>
			</p>
		</footer>
		
		<!-- Bootstrap and JQuery JAVASCRIPT -->
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="resources/js/jquery-1.11.3.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
	</body>
</html>