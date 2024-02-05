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
    <h1>부서목록</h1>
    <hr>
     
    <table id="customers">
        <thead>
            <tr>
                <th>부서번호</th>
                <th>부서이름</th>
                <th>매니저번호</th>
                <th>위치번호</th>
            </tr>
        </thead>
      <tbody>
            <tr>
                <td>${vo2.department_id}</td>
                <td>${vo2.department_name}</td>
                <td>${vo2.manager_id}</td>
                <td>${vo2.location_id}</td>
            </tr>
        </tbody>
       
    </table>
    <tfoot>
			<a href="deptUpdate.do?department_id=${param.department_id}">부서 수정</a>
			<a href="deptDelete.do?department_id=${param.department_id}">부서 삭제</a>
	</tfoot>
</body>
</html>