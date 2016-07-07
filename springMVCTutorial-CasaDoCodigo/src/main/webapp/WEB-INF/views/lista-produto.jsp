<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Listagem de Produtos</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>		
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
		<header>
			<div class="jumbotron containerApp" style="height: 140px">
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
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>