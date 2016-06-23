<!-- Menu Superior -->
<nav class="navbar navbar-inverse navbar-fixed-top menu" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li style="margin-left: 40px;">
                    <a href='<spring:url value="/usuario/cadastro"/>'>Cadastrar Usuário</a>
                </li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
	                <li>
	                    <a href='<spring:url value="/produto/cadastro"/>'>Cadastrar Livro</a>
	                </li>
                </security:authorize>
                <li>
                    <a href='<spring:url value="/produto/lista"/>'>Pesquisa Produto</a>
                </li>
                <li style="margin-left: 50px;">
                    <a href='<spring:url value="/carrinho/itens"/>'>
                    	<span class="glyphicon glyphicon-shopping-cart"></span> 
                    	Itens no Carrinho &#160; 
                    	<span>${carrinhoDeCompra.quantidade}</span>	
                   	</a>
                </li>
                <li style="margin-left: 50px;">
                    <a href='<spring:url value="/usuario/login"/>'>Login</a>
                </li>
                <li>
                    <a href='<spring:url value="/logout"/>'>Logout</a>
                </li>
				<security:authorize access="isAuthenticated()">
					<li style="margin-left: 50px;">
						<a href="#">
							<security:authentication property="principal" var="usuario"/>
							user: ${usuario.name}
						</a>	
					</li>
				</security:authorize>
            </ul>
        </div>
    </div>
</nav>
