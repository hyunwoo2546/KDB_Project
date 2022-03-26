<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="frm">
		<div>아이디 : <input type="text" id = "id" name="id"></div>
		<div>비밀번호 : <input type="password" id = "password" name="password"></div>
		<button type="button" onclick="fn_login();">로그인</button>
		<button type="button" onclick='location.href="/member/join"'>회원가입</button>
	</form>
</body>
</html>