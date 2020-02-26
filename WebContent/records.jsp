<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Registered Voters</title>
</head>
<body>
	<form method="post" action="">
		<table>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Political Party</th>
				<th>Registered Since</th>
			<c:forEach items="${requestScope.allVoters}" var="currentvoter">
				<tr>
					<td><input type="radio" name="id" value="${currentvoter.id}"></td>
					<td>${currentvoter.lastName}, ${currentvoter.firstName}</td>
					<td>${currentvoter.affiliation.name}</td>
					<td>${currentvoter.registrationDate}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToVoter">
		<input type="submit" value="delete" name="doThisToVoter">
		<input type="submit" value="add" name="doThisToVoter">
	</form>
	<a href="addAffiliationServlet">Create a New Affiliation</a>
	<a href="index.html">Return Home</a>
</body>
</html>