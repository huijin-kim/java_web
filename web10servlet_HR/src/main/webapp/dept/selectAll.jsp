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
    <form action="deptSearch.do">
    	<select name="searchKey">
    		<option value="department_name">department_name</option>
    		<option value="location_id">location_id</option>
    	</select>
    	<input type="text" name="searchWord" value="${param.searchWord}">
    	<input type="submit" value="search">
    	
    </form>
    <table id="customers">
        <thead>
            <tr>
                <th>부서번호</th>
                <th>부서이름</th>
                <th>매니저번호</th>
                <th>위치번호</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${vos}">
            <tr>
                <td><a href="deptOne.do?department_id=${vo.department_id}">${vo.department_id}</a></td>
                <td>${vo.department_name}</td>
                <td>${vo.manager_id}</td>
                <td>${vo.location_id}</td>
                <td><a href="deptDelete.do?department_id=${vo.department_id}">부서삭제</a></td>
            </tr>
        	</c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4">
                	<c:forEach var="i" begin="1" end="${totalPageCount}">
                		<c:if test="${param.searchKey== null}">
	                	<a href="deptAll.do?cpage=${i}">${i} &nbsp;</a>
                		</c:if>
                		<c:if test="${param.searchKey != null}">
                			<a href="deptSearch.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}</a>
                		</c:if>
                	</c:forEach>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>