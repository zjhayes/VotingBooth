<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Administration Console</title>
</head>
<body>
	<h1>Administration Console</h1>
	<form method="post" action="navigationServlet">
		<input type="submit" value="Edit Candidates" name="doThis">
	</form>
	<form method="post" action="navigationServlet">
		<input type="submit" value="Results" name="doThis">
		<input type="submit" value="Voter Registration" name="doThis">
		<br/><br/><br/>
		<a href="index.html">Return to Main Menu</a>
	</form>
</body>
</html>