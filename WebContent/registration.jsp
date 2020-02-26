<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Registration</title>
</head>
<body>
	<h1>Register New Voter</h1>
	<form action="registerVoterServlet" method="post">
		First Name: <input type="text" name="firstName"><br/>
		Last Name: <input type="text" name="lastName"><br/>
		Political Affiliation:
		<select name="affiliation">
			<c:forEach items="${requestScope.allAffiliations}" var="currentparty">
				<option value="${currentparty.id}">{$currentparty.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Register" name="doThis">
	</form>
	<a href="index.html">Return To Main Menu</a>
</body>
</html>