<div class="container formLogin">
	<div class="panel panel-default panel-primary">
		<div class="panel-heading">
		<h3 class="panel-title">Acesso ao Sistema</h3>
		</div>
		<div class="panel-body">
			<div class="cadastro-form">
				<form method="POST" action="/usuario/login" name="f">
					<security:csrfInput/>
					<div class="row" style="margin-bottom: 15px;margin-top: 20px">
						<div class="col-xs-12">
							<input value="" type="text" name="username" id="element-1" class="form-control" placeholder="informe o e-mail de login"/>
						</div>
					</div>
					<div class="row" style="margin-bottom: 15px;">
						<div class="col-xs-12">
							<input type="password" name="password" id="element-2" class="form-control" placeholder="informe a sua senha de acesso"/>
						</div>
					</div>
					<div class="form-group" style="margin-top: 15px">
						<input type="submit" name="submit" class="btn btn-primary" value="Entrar"/>
					</div>
				</form>
			</div>
		</div>
	</div>			
</div>		
