<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Voting Booth - Sign-in</title>
</head>
<body>
	<h1>Sign-in</h1>
	<form action="viewAllCandidatesServlet" method="post">
		Select Your Name:
		<select name="voter">
			<c:forEach items="${requestScope.allVoters}" var="currentvoter">
				<option value="${currentvoter.id}">${currentvoter.lastName}, ${currentvoter.firstName}</option>
			</c:forEach>
		</select>
		<h4>Do you promise this is really you?</h4>
		<input type="submit" value="Yes">
	</form>
	<form action="addAffiliationServlet">
		<h3>Not Registered?</h3>
		<input type="submit" value="Register To Vote" name="doThis">
	</form>
	<a href="index.html">Return to Main Menu</a>
</body>
</html>