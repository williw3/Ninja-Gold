<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header">
		<h3><c:out value="Your Current Gold: ${gold}"></c:out></h3>
		<form action="/reset" method="post">
			<button>New Game</button>		
		</form>
	</div>
	<div class="center">
		<div class="mine">
			<h3>Farm</h3>
			<form action="/mine" method="post">
				<input type="hidden" value="farm" name="mine">
				<button>Find Gold</button>
			</form>
		</div>
		<div class="mine">
			<h3>Cave</h3>
			<form action="/mine" method="post">
				<input type="hidden" value="cave" name="mine">
				<button>Find Gold</button>
			</form>
		</div>
		<div class="mine">
			<h3>House</h3>
			<form action="/mine" method="post">
				<input type="hidden" value="house" name="mine">
				<button>Find Gold</button>
			</form>
		</div>
		<div class="mine">
			<h3>Casino</h3>
			<form action="/mine" method="post">
				<input type="hidden" value="casino" name="mine">
				<button>Find Gold</button>
			</form>
		</div>
	</div>
	<div>
		<h3>Activity Log:</h3>
		<h5><c:out value="${mined}"></c:out></h5>
		<h5 class="red"><c:out value="${lost}"></c:out></h5>
	</div>
</body>
</html>