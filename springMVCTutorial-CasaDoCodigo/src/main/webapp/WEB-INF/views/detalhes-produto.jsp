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
	    <!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href='<spring:url value="/"/>'>HOME</a>
	            </div>
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li>
	                        <a href='<spring:url value="/produto/cadastro"/>'>Cadastrar Livro</a>
	                    </li>
	                    <li>
	                        <a href='<spring:url value="/produto/lista"/>'>Pesquisar Livro</a>
	                    </li>
	                    <li>
	                        <a href="#">Carrinho de compras</a>
	                    </li>
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container -->
	    </nav>
			
	    <!-- Page Content -->
	    <div class="container" style="margin-top: 30px;">
	        <!-- Book Title -->
	        <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header"> ${produto.titulo} </h1>
	                <h5>
	                	<strong>${produto.subtitulo}</strong>
	                </h5>
	            </div>
	        </div>
	        <!-- /.row -->
	        
			<!-- Item Row -->
	        <div class="row">
	            <div class="col-xs-3 col-md-4">
					<img src='<spring:url value="${produto.caminhoResumo}"/>' class="img-responsive" alt="${produto.caminhoResumo}">
	            </div>
	            <div class="col-md-4">
	                <h3>Resumo</h3>
					<p> ${produto.descricao} </p> 
	            </div>
	        </div>
	        <!-- /.row -->
			
			<!-- Lista de Preços -->
			<div class="btnValores row text-center">
				<form action='<c:url value="/carrinho" />' method="post" >
					<input type="hidden" value="${produto.id}">
					<c:forEach items="${produto.precos}" var="preco">
						<div class="radioValores col-md-3 hero-feature">
							<div class="radioValores2 thumbnail">
								<div class="radioValores3 caption">
									<h4>
										<input type="radio" name="tipo" id="${produto.id}-${preco.tipoProduto}" value="${preco.tipoProduto}" 
										    ${preco.tipoProduto == 'COMBO' ? 'checked' : ''}	/>
										&#160;
										<strong>${preco.tipoProduto}</strong>
									</h4>
									<h6> R$ ${preco.valor} </h6>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="radioValores4 col-md-3 hero-feature">
				        <input type="submit" class="btn btn-success btn-xl" value="Comprar"/>
					</div>
				</form>
			</div>
			<!--  /.div form -->
		</div>
	    <!-- / .Page Content -->
		
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