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
        #customers {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
        
        #customers td, #customers th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        
        #customers tr:nth-child(even){background-color: #ff6565;}
        
        #customers tr:hover {background-color: #fca2a2;}
        
        #customers th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #04AA6D;
          color: white;
        }

        tfoot td{
            text-align: center; 
        }
        </style>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h1>사원목록</h1>
    <hr>
    
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>성</th>
                <th>이메일</th>
                <th>전화번호</th>
                <th>입사일</th>
                <th>사원번호</th>
                <th>연봉</th>
                <th>보너스</th>
                <th>매니저번호</th>
                <th>부서번호</th>
               
            </tr>
        </thead>
          <tbody>
            <tr>
                <td>${vo2.employee_id}</td>
                <td>${vo2.first_name}</td>
                <td>${vo2.last_name}</td>
                <td>${vo2.email}</td>
                <td>${vo2.phone_number}</td>
                <td>${vo2.hire_date}</td>
                <td>${vo2.job_id}</td>
                <td>${vo2.salary}</td>
                <td>${vo2.commission_pct}</td>
                <td>${vo2.manager_id}</td>
                <td>${vo2.department_id}</td>
             </tr>
        </tbody>
		
	</table>
	<tfoot>
		<a href="empUpdate.do?employee_id=${param.employee_id}">회원수정</a>
		<a href="empDelete.do?employee_id=${param.employee_id}">회원삭제</a>
	</tfoot>
</body>
</html>