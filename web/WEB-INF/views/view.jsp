<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-18
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>게시물 보기</title>
</head>
<body>
    <c:forEach var="view" items="${view}">
        닉네임 : ${view.nick_name} <br>
        작성일 : ${view.created_at} <br>
        제목 : ${view.title} <br>
        내용 : ${view.content} <br>
        조회수 : ${view.view_count} <br>
        <a href ="/board">목록으로</a>
        <a href = "/board/modify/${view.id}">게시글 수정</a>
        <a href = "/board/delete/${view.id}">게시물 삭제</a>
        <br>
        <br>
    </c:forEach>

    <c:forEach var="reply" items="${reply}">
        작성자 : ${reply.nick_name} | ${reply.created_at} <br>
        내용 : ${reply.content}<br>
        <a href="/reply/delete/${reply.id}">삭제</a>
        <a href="/reply/modify/${reply.id}">수정</a>
        <br><br>
    </c:forEach>

<form action="/reply" method="post">
    <c:forEach var="view" items="${view}">
        <input name="board_id" type="hidden" value="${view.id}">
        <input name="user_id" type="hidden" value="${userID}">
        <label> 작성자 :</label>
        <input name="nick_name" value="${nick_name}" readonly="ture">
        <labeㅣ> 내용 :</labeㅣ>
        <input name="content" type="text">
        <input type="submit" value="작성">
    </c:forEach>
</form>
</body>
</html>