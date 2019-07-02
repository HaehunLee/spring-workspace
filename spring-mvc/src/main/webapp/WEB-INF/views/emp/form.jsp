<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 등록 폼</h1>
	<form method="post" action="register.do">
		<p>아이디 : <input type="text" name="id"/></p>
		<p>성     : <input type="text" name="firstName"/></p>
		<p>이  름 : <input type="text" name="lastName"/></p>
		<p>이 메 일 : <input type="text" name="email"/></p>
		<p>전화번호 : <input type="text" name="phoneNumber"/></p>
		<p>고 용 일 : <input type="text" name="hireDate"/></p>
		<p>직종 아이디 : <input type="text" name="jobId"/></p>
		<p>급 여  : <input type="text" name="salary"/></p>
		<p>커미션  : <input type="text" name="commissionPct"/></p>
		<p>관리자 아이디  : <input type="text" name="managerId"/></p>
		<p>소속부서 아이디 : <input type="text" name="deptpartmentId"/></p>
		<p><button type="submit">등록</button></p>
	</form>
</body>
</html>