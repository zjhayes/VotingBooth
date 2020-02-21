<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Cast Your Vote</title>
</head>
<body>
	<form method="post" action="castVoteServlet">
		<table>
			<c:forEach items="${requestScope.allCandidates}" var="currentcandidate">
				<tr>
					<td><input type="radio" name="id" value="${currentcandidate.id}"></td>
					<td>${currentcandidate.name}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="radio" name="id" value="custom"></td>
				<td>Write-in: <input type="text" name="custom"></td>
			</tr>
		</table>
		<input type="submit" value="Vote">
	</form>
</body>
</html>