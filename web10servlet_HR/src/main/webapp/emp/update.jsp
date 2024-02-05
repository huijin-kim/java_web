<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], input[type=password], input[type=tel], select {
	width: 100%;
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 30%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 15px;
	background-color: #bfbfbf;
	padding: 20px;
}

#empTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#empTable td {
	border: 1px solid #ddd;
	padding: 8px;
}

#empTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#empTable tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h3>사원수정폼</h3>

		<!-- <form action="#" method="post" enctype="multipart/form-data"> -->
		<form action="empUpdateOK.do" method="post">
			<table id="empTable">
				<tr>
					<td><label for="employee_id">employee_id:</label></td>
					<td>${param.employee_id}<input type="hidden" id="employee_id" name="employee_id"
						value="${param.employee_id}" ></td>
				</tr>
				<tr>
					<td><label for="first_name">first_name:</label></td>
					<td><input type="text" id="first_name" name="first_name"
						value="${vo2.first_name}" placeholder="이름"></td>
				</tr>
				<tr>
					<td><label for="last_name">last_name:</label></td>
					<td><input type="text" id="last_name" name="last_name"
						value="${vo2.last_name}" placeholder="성"></td>
				</tr>
				<tr>
					<td><label for="email">email:</label></td>
					<td><input type="text" id="email" name="email" value="${vo2.email}"
						placeholder="이메일"></td>
				</tr>
				<tr>
					<td><label for="phone_number">phone_number:</label></td>
					<td><input type="text" id="phone_number" name="phone_number"
						value="${vo2.phone_number}" placeholder="phone_number"></td>
				</tr>
				<tr>
					<td><label for="hire_date">hire_date:</label></td>
					<td><input type="date" id="hire_date" name="hire_date"
						value="${vo2.hire_date}" placeholder="hire_date"></td>
				</tr>
				<tr>
					<td><label for="job_id">job_id:</label></td>
					<td><select name="job_id">
							<c:forEach var="vo" items="${job_ids}">
								<option value="${vo.job_id}">${vo.job_id}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label for="salary">salary:</label></td>
					<td><input type="number" id="salary" name="salary"
						value="${vo2.salary}" placeholder="salary"></td>
				</tr>
				<tr>
					<td><label for="commission_pct">commission_pct:</label></td>
					<td><input type="number" id="commission_pct"
						name="commission_pct" value="${vo2.commission_pct}" placeholder="commission_pct"></td>
				</tr>
				<tr>
					<td><label for="manager_id">manager_id:</label></td>
					<td><select name="manager_id">
							<c:forEach var="vo" items="${manager_ids}">
								<option value="${vo.manager_id}">${vo.manager_id}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label for="department_id">department_id:</label></td>
					<td>
					<select name="department_id">
							<c:forEach var="vo" items="${department_ids}">
								<option value="${vo.department_id}">${vo.department_id}</option>
							</c:forEach>
					</select>
					</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="사원수정"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>