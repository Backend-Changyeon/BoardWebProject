<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-19
  Time: 오후 5:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/board/modify", method="post">
<c:forEach var="modify" items="${modify}">
    <input name="id" type="hidden" value="${modify.id}">
    <input name="user_id" type="hidden" value="${userID}">
    <label>닉네임 :</label>
    <input name="nick_name" value="${modify.nick_name}" readonly="true" type="text"><br>
    <label>제목 :</label>
    <input name="title" type="text"><br>
    <label>내용 :</label>
    <input name="content" type="text" style="width:200px; height:50px;"><br>
    <input type="submit" value="작성">
</c:forEach>
</form>
</body>
</html>
