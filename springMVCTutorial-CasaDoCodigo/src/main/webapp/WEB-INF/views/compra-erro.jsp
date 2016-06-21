<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Erro na Compra</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="/WEB-INF/views/estilos.jsp"/>		
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
			<div class="jumbotron headerIndex">
				<div class="container">
					<h2>COMPRA NÃO AUTORIZADA</h2>
				</div>
			</div>
		</header>
		
		<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
			<h3 style="text-align: center;">Compra não aprovada por exceder o valor máxima de 500,00 reais por compra</h3>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
		<jsp:include page="/WEB-INF/views/scripts.jsp"/>
	</body>
</html>