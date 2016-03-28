<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Lista de Produtos (livros)</title>
		
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
					<h2>Listagem de Livros</h2>
					<h6>Tutorial Spring MVC 4 - livro casa do código</h6>
				</div>
			</div>
		</header>
		<div class="novoBtn">
			<a class="btn btn-success" href="/springTutorialCasaDoCodigo/">
				HOME
			</a>
		</div>
		<div class="novoBtn">
	        <a href="/springTutorialCasaDoCodigo/produto/cadastro" class="btn btn-info btn-md">Novo Produto</a>
		</div>
		<div class="${sucesso != null ? 'showSuccess' : 'hideSuccess'} alert alert-success">
			<strong>${sucesso}</strong>
		</div>

		<div class="container">
			<div class="well">
				<table class="table table-striped">
					<tr>
						<th>Titulo</th>
						<th>descrição</th>
						<th>valor</th>
					</tr>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.titulo}</td>
							<td>${produto.descricao}</td>
							<td>
								<c:forEach items="${produto.precos}" var="preco">
									<strong>${preco.tipoProduto}</strong>: ${preco.valor}
									&#160;&#160;
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	
		<footer class="footer" style="margin-top: 10px">
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