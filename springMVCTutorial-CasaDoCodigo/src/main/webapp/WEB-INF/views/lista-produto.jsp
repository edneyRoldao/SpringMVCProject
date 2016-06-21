<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Listagem de Produtos</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="/WEB-INF/views/estilos.jsp"/>		
	</head>
	<body>
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
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li>
	                        <a href='<spring:url value="/produto/cadastro"/>'>Cadastrar Livro</a>
	                    </li>
	                    <li>
	                        <a href='<spring:url value="/carrinho/itens"/>'>
	                        	Finalizar Compra - Itens 
	                        	(<span>${carrinhoDeCompra.quantidade}</span>)	
                        	</a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
	
		<header>
			<div class="jumbotron headerListagem" style="height: 140px">
				<div class="container" style="margin-top: -30px">
					<h2>Listagem de Livros</h2>
					<h6>Tutorial Spring MVC 4 - livro casa do código</h6>
				</div>
			</div>
		</header>

		<div class="${sucesso != null ? 'showSuccess' : 'hideSuccess'} alert alert-success">
			<strong>${sucesso}</strong>
		</div>

		<div class="container">
			<div class="well">
				<table class="table table-striped">
					<tr>
						<th>Titulo</th>
						<th>subtitulo</th>
						<th>Lançamento</th>
						<th>valores</th>
						<th>Ações</th>
					</tr>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.titulo}</td>
							<td>${produto.subtitulo}</td>
							<td>
								<fmt:formatDate pattern="MM/dd/yyyy" value="${produto.dataLancamento.time}" />
							</td>
							<td>
								<c:forEach items="${produto.precos}" var="preco">
									<strong>${preco.tipoProduto}</strong>: ${preco.valor}
									&#160;&#160;
								</c:forEach>
							</td>
							<td>
								<a href='<spring:url value="/produto/detalhes/${produto.id}"/>' class="btn-sm btn-primary"> detalhes </a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
		<jsp:include page="/WEB-INF/views/scripts.jsp"/>
	</body>
</html>