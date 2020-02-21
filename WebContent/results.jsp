<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Results</title>
</head>
<body>
	<h1>Voting Booth Results</h1>
	<form method="post" action="castVoteServlet">
		<table>
			<c:forEach items="${requestScope.sortedCandidates}" var="currentcandidate">
				<tr>
					<td><input type="radio" name="id" value="${currentcandidate.id}"></td>
					<td>${currentcandidate.name}</td>
					<td>${currentcandidate.votes}</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/><br/>
		<a href="index.html">Return Home</a>
	</form>

</body>
</html>