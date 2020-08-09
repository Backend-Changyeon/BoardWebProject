<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 목록</title>
</head>
<body>
<h2>게시글 목록</h2>
${nick_name}으로 접속중 <br>
<a href ="/board/write">글쓰기</a>
<a href ="/logout">로그아웃</a>
<a href="/message">쪽지함</a>
<table border="1" width="600px">
    <tr align="center">
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${list}">
        <tr align="center">
            <td width="50px">${row.id}</td>
            <td width="150px"><a href="/writeMessage/${row.nick_name}">${row.nick_name}</a></td>
            <td width="200px"><a href="/board/${row.id}">${row.title}</a></td>
            <td width="150px"><fmt:formatDate value="${row.updated_at}" pattern="yyyy.MM.dd HH:mm"/> </td>
            <td width="50px">${row.view_count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>