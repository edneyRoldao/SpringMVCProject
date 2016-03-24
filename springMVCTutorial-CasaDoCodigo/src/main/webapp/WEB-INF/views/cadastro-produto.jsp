<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Cadastro de Produto</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	    <!-- Bootstrap -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	    <link href="../resources/css/bootstrap.min.css" rel="stylesheet"/>
	    <link href="../resources/css/springTutorial.css" rel="stylesheet"/>
	</head>
	<body>
	
		<header>
			<div class="jumbotron">
				<div class="container">
					<h2>Cadastro de Livros</h2>
					<h6>Tutorial Spring MVC 4 - livro casa do código</h6>
				</div>
			</div>
		</header>
		
		<div class="container" style="margin-top: 70px">
			<form method="post" action="/springTutorialCasaDoCodigo/produtos">
				<c:forEach items="${tipos}" var="tipoProduto" varStatus="status">
					<div>
						<label for="preco_${tipoProduto}">${tipoProduto}</label>
						<input id="preco_${tipoProduto}" type="text" name="precos[${status.index}].valor">
						<input type="hidden" name="precos[${status.index}].tipoProduto" value="${tipoProduto}">
					</div>
				</c:forEach>
				<div class="form-group">
					<label for="element-1" class="sr-only">Título</label>
					<input type="text" name="titulo" id="element-1" class="form-control" placeholder="insira o nome do livro">
					<span class="glyphicon glyphicon-remove form-control-feedback"></span>
				</div>
				<div class="form-group">
					<label for="element-2" class="sr-only">Descrição</label>
					<input type="text" name="descricao" id="element-4" class="form-control" placeholder="insira a descrição do livro">
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
				<div class="form-group">
					<label for="element-4" class="sr-only">Número de páginas</label>
					<input type="text" name="paginas" id="element-4" class="form-control" placeholder="coloque o número de páginas">
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
				<div class="form-group" style="margin-top: 35px">
					<input type="submit" class="btn btn-primary" value="Cadastrar"/>
				</div>
			</form>
		</div>		
		
		<footer class="footer" style="margin-top: 300px">
			<p>
				© 2016 - Developed by Edney Roldão &#160;&#160;
				<img src="../resources/img/avatar.jpg"/>
			</p>
		</footer>
		
		<!-- Bootstrap and JQuery JAVASCRIPT -->
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="../resources/js/jquery-1.11.3.min.js"></script>
		<script src="../resources/js/bootstrap.min.js"></script>
	</body>
</html>