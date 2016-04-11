<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Cadastro de Produto (livros)</title>
		
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
		
		<div class="novoBtn">
	        <a href='<spring:url value="/produto/lista"/>' class="btn btn-primary btn-sm">Pesquisa de Livros</a>
		</div>
		
		<div class="container" style="margin-top: 10px">
			<form:form method="post" action="/springTutorialCasaDoCodigo/produto/lista" commandName="produto" enctype="multipart/form-data">
				<div class="form-group">
					<form:errors path="titulo" cssClass="errorMessages"/>
					<label for="element-1" class="sr-only">Título</label>
					<form:input path="titulo" id="element-1" class="form-control" placeholder="insira o nome do livro"/>
					<span class="glyphicon glyphicon-remove form-control-feedback"></span>
				</div>
				<div class="form-group">
					<form:errors path="descricao" cssClass="errorMessages"/>
					<label for="element-2" class="sr-only">Descrição</label>
					<form:input path="descricao" id="element-2" class="form-control" placeholder="insira a descrição do livro"/>
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
				<div class="form-group">
					<form:errors path="paginas" cssClass="errorMessages"/>
					<label for="element-3" class="sr-only">Número de páginas</label>
					<form:input path="paginas" id="element-3" class="form-control" placeholder="coloque o número de páginas"/>
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
				<div class="form-group">
					<form:errors path="dataLancamento" cssClass="errorMessages"/>
					<label for="element-3" class="sr-only">Data de Lançameto</label>
					<form:input type="date" path="dataLancamento" id="element-3" class="form-control" placeholder="informe a data de lançamento"/>
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
				<div style="position:relative;">
					<a class='btn btn-primary' href='javascript:;'>
					    Choose File...
					    <input type="file" name="resumo" class="btn-file" size="40"  onchange='$("#upload-file-info").html($(this).val());'>
					</a>
					&nbsp;
					<span class='label label-info' id="upload-file-info"></span>
				</div>
				<br/>
				<h4>Preço para cada tipo de livro</h4>
				<c:forEach items="${tipos}" var="tipoProduto" varStatus="status">
					<div class="form-group">
						<form:errors path="precos[${status.index}].valor" cssClass="errorMessages"/>
						<form:input path="precos[${status.index}].valor" id="preco_${tipoProduto}" type="text" name="precos[${status.index}].valor" class="form-control" placeholder="${tipoProduto}"/>
						<input type="hidden" name="precos[${status.index}].tipoProduto" value="${tipoProduto}">
					</div>
				</c:forEach>
				<div class="form-group" style="margin-top: 35px">
					<input type="submit" class="btn btn-primary" value="Cadastrar"/>
				</div>
			</form:form>
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