<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Affiliation</title>
</head>
<body>
	<form action="createAffiliationServlet" method="post">
		Affiliation Name: <input type="text" name="affiliationName"><br/>
		
	</form>
</body>
</html>