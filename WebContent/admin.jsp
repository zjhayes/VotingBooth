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
		<table>
			<c:forEach items="${requestScope.allCandidates}" var="currentcandidate">
				<tr>
					<td><input type="radio" name="id" value="${currentcandidate.id}"></td>
					<td>${currentcandidate.name}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Delete" name="doThis">
		<input type="submit" value="Results" name="doThis">
		<input type="submit" value="Voter Registration" name="doThis">
		<br/><br/><br/>
		<a href="/index.html">Return Home</a>
	</form>
</body>
</html>