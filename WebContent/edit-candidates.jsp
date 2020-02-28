<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Edit Candidates</title>
</head>
<body>
	<h1>Edit Candidates</h1>
	<form method="post" action="editCandidateServlet">
		<table>
			<c:forEach items="${requestScope.affiliatedCandidates}" var="currentcandidate">
				<tr>
					<td><input type="radio" name="id" value="${currentcandidate.id}"></td>
					<td>${currentcandidate.name}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Delete" name="doThis">
		<input type="submit" value="Edit" name="doThis">
		<br/><br/><br/>
		<a href="admin.jsp">Return to Admin Console</a>
	</form>
</body>
</html>