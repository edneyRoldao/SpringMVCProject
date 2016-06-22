<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>itens no carrinho</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>		
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
	    <header>
			<div class="jumbotron containerApp" style="height: 140px">
				<div class="container" style="margin-top: -30px">
					<h2>Finalizando a Compra</h2>
					<h5>Valor total dos ítens adicionados R$ ${carrinhoDeCompra.total}</h5>					
				</div>
			</div>
		</header>
	    <div class="container" style="width: 1150px">
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
						<security:csrfInput/>
						<input type="submit" value="Finalizar Compra ( total R$ ${carrinhoDeCompra.total} )" class="btn btn-default btn-success">
					</form>						
				</div>			
	    	</div>
		</div>
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>