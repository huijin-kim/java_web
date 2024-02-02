<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        input[type=text],
        textarea,
        select {
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
            background-color: #b7e5b9;
        }

        div {
            border-radius: 15px;
            background-color: #f0f0f0;
            padding: 20px;
        }

        #insertTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #insertTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #insertTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #insertTable tr:hover {
            background-color: #ffc6c6;
        }
    </style>
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div>
        <h3>사원등록폼</h3>

        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="empInsertOK.do" method="post">
            <table id="empTable">
                <tr>
                    <td><label for="first_name">first_name:</label></td>
                    <td><input type="text" id="first_name" name="first_name" value="GilDong" placeholder="이름"></td>
                </tr>
                <tr>
                    <td><label for="last_name">last_name:</label></td>
                    <td><input type="text" id="last_name" name="last_name" value="홍" placeholder="성"></td>
                </tr>
                <tr>
                    <td><label for="email">email:</label></td>
                    <td><input type="text" id="email" name="email" value="HONG" placeholder="이메일"></td>
                </tr>
                <tr>
                    <td><label for="phone_number">phone_number:</label></td>
                    <td><input type="text" id="phone_number" name="phone_number" value="515.123.8888" placeholder="phone_number"></td>
                </tr>
                <tr>
                    <td><label for="hire_date">hire_date:</label></td>
                    <td><input type="date" id="hire_date" name="hire_date" value="2024-02-01" placeholder="hire_date"></td>
                </tr>
                <tr>
                    <td><label for="job_id">job_id:</label></td>
                    <td>
                    	<select name="job_id">
                    		<c:forEach var="jobs" items="${job_ids}">
                    			<option value ="${jobs.job_id}">${jobs.job_id}</option>
                    		</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td><label for="salary">salary:</label></td>
                    <td><input type="number" id="salary" name="salary" value="6000" placeholder="salary"></td>
                </tr>
                <tr>
                    <td><label for="commission_pct">commission_pct:</label></td>
                    <td><input type="number" id="commission_pct" name="commission_pct" value="0.1" placeholder="commission_pct"></td>
                </tr>
                <tr>
                    <td><label for="manager_id">manager_id:</label></td>
                     <td>
                    	<select name="manager_id">
                    		<c:forEach var="managers" items="${manager_ids}">
                    			<option value ="${managers.manager_id}">${managers.manager_id}</option>
                    		</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td><label for="department_id">department_id:</label></td>
                    <td>
                    	<select name="department_id">
                    		<c:forEach var="departments" items="${department_ids}">
                    			<option value ="${departments.department_id}">${departments.department_id}</option>
                    		</c:forEach>
                    	</select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="사원등록"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>