<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<h1>file_all.jsp</h1>
	
	<table border="1">
		<tr>
			<td>name</td>
			<td>age</td>
			<td>file</td>
			<td>img</td>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td>${vo.save_name}</td>
				<td><img src="uploadimg/${vo.save_name}" width="60"></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html> 