<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <!-- Bootstrap -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	    <link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet"/>
	    <link href='<c:url value="/resources/css/springTutorial.css"/>' rel="stylesheet"/>
	    <link href='<c:url value="/resources/css/springTutorialRadioStyle.css"/>' rel="stylesheet"/>
	</head>
	<body>
		<header>
			<div class="jumbotron headerIndex" style="height: 140px">
				<div class="container" style="margin-top: -50px">
					<h2>Login</h2>
					<h6>Tutorial Spring MVC 4 - livro casa do código</h6>
				</div>
			</div>
		</header>
		<div class="container" style="margin-top: 10px; width: 1000px;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
				<h3 class="panel-title">Acesso ao Sistema</h3>
				</div>
				<div class="panel-body">
					<div class="cadastro-form">
						<form:form method="post" action="/springTutorialCasaDoCodigo/login">
							<security:csrfInput/>						
							<div class="row">
								<div class="col-xs-6">
									<label for="element-1" class="sr-only">User Name</label>
									<input id="element-1" class="form-control" placeholder="informe o login"/>
								</div>
								<div class="col-xs-6">
									<label for="element-2" class="sr-only">Password</label>
									<input id="element-2" class="form-control" placeholder="informe a senha"/>
								</div>					
							</div>
							<div class="form-group" style="margin-top: 15px">
								<input type="submit" class="btn btn-primary" value="Login"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>			
		</div>		
		<footer class="footer" style="margin-top: 10px">
			<p>
				© 2016 - Developed by Edney Roldão &#160;&#160;
				<img src="/resources/img/avatar.jpg"/>
				<img src='<c:url value="../../resources/img/avatar.jpg"/>'/>
			</p>
		</footer>
		<!-- Bootstrap and JQuery JAVASCRIPT -->
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src='<c:url value="/resources/js/jquery-1.11.3.min.js"/>'></script>
		<script src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>
	</body>
</html>