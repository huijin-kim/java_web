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
    <form action="empAll.do">
    	<select name="searchKey">
    		<option value="title">title</option>
    		<option value="content">content</option>
    	</select>
    	<input type="text" name="searchWord" value="ja">
    	<input type="submit" value="search">
    	
    </form>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>이름성</th>
                <th>이름</th>
                <th>이메일</th>
                <th>전화번</th>
                <th>입사</th>
                <th>사원번</th>
                <th>입사</th>
                <th>보너스</th>
                <th>매니저번호</th>
                <th>부서번호</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${vos}">
            <tr>
                <td><a href="empSelectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
                <td>${vo.first_name}</td>
                <td>${vo.last_name}</td>
                <td>${vo.email}</td>
                <td>${vo.phone_number}</td>
                <td>${vo.hire_date}</td>
                <td>${vo.job_id}</td>
                <td>${vo.salary}</td>
                <td>${vo.commission_pct}</td>
                <td>${vo.manager_id}</td>
                <td>${vo.department_id}</td>
              <%--   <td><a href="b_delete.do?num=${vo.num}">글삭제</a></td> --%>
            </tr>
        	</c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
                <td colspan="11">
                	<c:forEach var="i" begin="1" end="${totalPageCount}">
	                	<a href="empAll.do?cpage=${i}">${i} &nbsp;</a>
                	</c:forEach>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>