<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-26
  Time: 오전 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>쪽지함</title>
</head>
<body>
<a href="/writeMessage">쪽지쓰기</a> <br>
<c:forEach var="msg" items="${msg}">
    보낸사람 : ${msg.from_user_nick_name}<br>
    작성일 : ${msg.sent_at} <br>
    내용 : ${msg.content} <br>
    <br>
    <br>
</c:forEach>
---------------------------쪽지 끝----------------------------
</body>