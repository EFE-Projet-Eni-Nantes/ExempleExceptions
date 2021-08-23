<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	label{
		display: inline-block;
		width: 70px;
	}
	
	.error{
		color : red;
		font-style: italic;
	}
</style>
</head>
<body>
	<h1>Formulaire</h1>
	
	<c:if test="${not empty erreurs }">
		<div class = "error">
			Il existe des erreurs :
			<ul>
				<c:forEach items="${erreurs}" var="e">
					<li>${e }</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	
	<form action = "formulaire" method="post">
		<p>
			<label for = "nom">Nom :</label>
			<input type = "text" name = "nom" id = "nom" value="${param.nom }">
		</p>
		<p>
			<label for = "prenom">Prénom :</label>
			<input type = "text" name = "prenom" id = "prenom" value="${param.prenom }">
		</p>
		<p>
			<label for = "age">Age :</label>
			<input type = "number" name = "age" id = "age" value="${param.age }">
		</p>
		<p>
			<button>Valider</button>
		</p>
	</form>
</body>
</html>