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
				<th>사원 아이디</th>
				<th>사원명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${emps }">
				<tr>
					<td>${c.id }</td>
					<td><a href="employee.do?empId=${c.id }">${c.firstName } ${c.lastName }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>