<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>관리자</th>
				<th>지역 아이디</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${depts }">
				<tr>
					<td>${c.id }</td>
					<td><a href="employees.do?deptId=${c.id }">${c.name }</a></td>
					<td>${c.managerId }</td>
					<td>${c.locationId }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>