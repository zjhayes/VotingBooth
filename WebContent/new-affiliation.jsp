<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>New Affiliation</title>
</head>
<body>
	<form action="createAffiliationServlet" method="post">
		Affiliation Name: <input type="text" name="affiliationName"><br/>
		Associate Candidates:
		<select name="allCandidatesToAdd" multiple size="6">
		<c:forEach items="${requestScope.allCandidates}" var="currentcandidate">
			<option value="${currentcandidate.id}">${currentcandidate.name}</option>
		</c:forEach>
		</select>
		<br/>
		<input type="submit" value="Create Affiliation">
	</form>
	<a href="admin.jsp">Return to Admin Console</a>
</body>
</html>