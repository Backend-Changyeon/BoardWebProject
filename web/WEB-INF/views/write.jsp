<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-18
  Time: 오전 12:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>게시물 작성</title>
</head>
<body>
    <form action="/board/write", method="post">
        <input name="user_id" value="${userID}" type="hidden">
        <input name="nick_name" value="${nick_name}" type="hidden" ><br>
        <label>제목 :</label>
        <input name="title" type="text"><br>
        <label>내용 :</label>
        <input name="content" type="text" style="width:200px; height:50px;"><br>
        <input type="submit" value="작성">
    </form>
</body>
</html>
