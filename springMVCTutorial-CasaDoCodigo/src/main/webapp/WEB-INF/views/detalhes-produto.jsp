<%@ include file="../templates/taglib.jsp" %>
<html>
	<head>
		<title>Detalhes do Produto</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="../templates/estilos.jsp" %>
	</head>
	<body>
		<%@ include file="../templates/menu.jsp" %>
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
	        <div class="row">
	            <div class="col-xs-3 col-md-4">
					<img src='<spring:url value="/produto/displayImage/?id=${produto.imagem.id}"/>' class="img-responsive imgDetalhes" alt="${produto.imagem.id}">
	            </div>
	            <div class="col-md-8">
	                <h3>Resumo</h3>
					<p> ${produto.descricao} </p> 
	            </div>
	        </div>
			<div class="btnValores row text-center">
				<form:form action="/carrinho" method="post" >
					<security:csrfInput/>
					<input type="hidden" value="${produto.id}" name="idProduto">
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
				</form:form>
			</div>
		</div>
		<%@ include file="../templates/footer.jsp" %>
		<%@ include file="../templates/scripts.jsp" %>
	</body>
</html>