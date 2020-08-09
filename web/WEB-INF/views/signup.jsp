
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>

<form action="/signup", method="post">
    <label>계정(e-mail) : </label>
    <input name="account" type="email"><br>
    <label>비밀번호 :</label>
    <input name="password" type="password" minlength="10" maxlength="20" required><br>
    <label>닉네임 :</label>
    <input name="nick_name" type="text" minlength="3" maxlength="15" required><br>
    <input type="submit" value="회원가입">
</form>
</body>
</html>