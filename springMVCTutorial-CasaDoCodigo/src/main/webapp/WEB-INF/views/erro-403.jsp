<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Acesso não permitido</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="/WEB-INF/views/estilos.jsp"/>		
	</head>
	<body>
		<header>
			<div class="jumbotron headerIndex">
				<div class="container">
					<h2>ACESSO NÃO AUTORIZADO !</h2>
				</div>
			</div>
		</header>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
		<jsp:include page="/WEB-INF/views/scripts.jsp"/>
	</body>
</html>