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

	<h1>fileupload.jsp</h1>
	
	<form action="file_uploadOK.do"method="post" enctype="multipart/form-data">
		<input type="text" name="name" value="kim">
		<input type="text" name="age" value="33">
		<input type="file" name="file">
		<input type="submit">
	
	</form>
	
</body>
</html> 