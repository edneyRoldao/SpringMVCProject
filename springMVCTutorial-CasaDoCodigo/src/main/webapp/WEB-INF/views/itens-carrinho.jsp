<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Página de detalhes</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	    <!-- Bootstrap -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	    <link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet"/>
	    <link href='<c:url value="/resources/css/springTutorial.css"/>' rel="stylesheet"/>
	    <link href='<c:url value="/resources/css/springTutorialRadioStyle.css"/>' rel="stylesheet"/>
	    
	</head>
	<body>
	
		<h1>Itens do Carrinho</h1>	
	
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li>
					<a href="#">
						Seu Carrinho de compras
						<span>${carrinhoDeCompra.quantidade}</span>	
					</a>
				</li>
			</ul>
		</div>
		
		<div>
		   <a href='<spring:url value="/produto/lista"/>'>Pesquisar mais livro</a>
		</div>
		
		<footer class="footer" style="margin-top: 10px">
			<p>
				© 2016 - Developed by Edney Roldão &#160;&#160;
				<img src='<c:url value="/resources/img/avatar.jpg"/>'/>
			</p>
		</footer>
		
		<!-- Bootstrap and JQuery JAVASCRIPT -->
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src='<c:url value="/resources/js/jquery-1.11.3.min.js"/>'></script>
		<script src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>
	</body>
</html>