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
                <li>
                    <a href='<spring:url value="/usuario/cadastro"/>'>Cadastrar Usuário</a>
                </li>
                <li>
                    <a href='<spring:url value="/produto/cadastro"/>'>Cadastrar Livro</a>
                </li>
                <li>
                    <a href='<spring:url value="/produto/lista"/>'>Pesquisa Produto</a>
                </li>
                <li style="margin-left: 100px;">
                    <a href='<spring:url value="/usuario/login"/>'>Login</a>
                </li>
                <li>
                    <a href='<spring:url value="/usuario/logout"/>'>Logout</a>
                </li>                
                <li style="margin-left: 200px;">
                    <a href='<spring:url value="/carrinho/itens"/>'>
                    	<span class="glyphicon glyphicon-shopping-cart"></span> 
                    	Itens no Carrinho &#160; 
                    	<span>${carrinhoDeCompra.quantidade}</span>	
                   	</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
