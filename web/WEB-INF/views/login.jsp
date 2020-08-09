
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Login</h1>
<form action="login", method="post">
    <label>ACCOUNT </label>
    <input name="account" type="email"> <br>
    <label>PW </label>
    <input name="password" type="password"><br>
    <button type="submit">로그인</button>
    <button type="submit" form="join">회원가입</button>
</form>
<form action="/signup" method="get" id="join"></form>
</body>