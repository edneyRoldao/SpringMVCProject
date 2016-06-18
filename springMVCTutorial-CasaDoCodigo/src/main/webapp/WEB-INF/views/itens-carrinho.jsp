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
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href='<spring:url value="/"/>'>HOME</a>
	            </div>
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li>
	                        <a href='<spring:url value="/produto/cadastro"/>'>Cadastrar Livro</a>
	                    </li>
	                    <li>
	                        <a href='<spring:url value="/produto/lista"/>'>Pesquisar Livro</a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
	    
	    <header>
			<div class="jumbotron headerListagem" style="height: 140px">
				<div class="container" style="margin-top: -30px">
					<h2>Finalizando a Compra</h2>
					<h5>Valor total dos ítens adicionados R$ ${carrinhoDeCompra.total}</h5>					
				</div>
			</div>
		</header>
	    
	    <div class="container" style="width: 1000px">
	    	<div class="panel panel-default panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Total de ítens da compra: &#160; ${carrinhoDeCompra.quantidade}</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>Titulo</th>
							<th>Subtitulo</th>
							<th>Tipo</th>
							<th>Valor</th>
							<th>Quantidade</th>
							<th>Subtotal</th>							
							<th>Ações</th>
						</tr>
						<c:forEach items="${carrinhoDeCompra.lista}" var="item">
							<tr>
								<td>${item.produto.titulo}</td>
								<td>${item.produto.subtitulo}</td>
								<td>${item.tipoProduto}</td>
								<td>${item.preco}</td>
								<td> &#160;&#160;&#160;&#160;&#160;&#160;&#160; ${carrinhoDeCompra.getQuantidade(item)}</td>
								<td>R$ ${carrinhoDeCompra.getTotal(item)}</td>
								<td>
									<a href='<spring:url value="/produto/detalhes/${produto.id}"/>' class="btn-sm btn-primary"> Remover </a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="panel-footer">
					<form method="post" action="/springTutorialCasaDoCodigo/pagamento/finaliza">
						<input type="submit" value="Finalizar Compra ( total R$ ${carrinhoDeCompra.total} )" class="btn btn-default btn-success">
					</form>						
				</div>			
	    	</div>
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