<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-24
  Time: 오후 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="reply" items="${reply}">
    <form action="/reply/modify", method="post">
    <input name="id" type="hidden" value="${reply.id}">
    <input name="nick_name" type="hidden" value="${nick_name}" readonly="true" type="text"><br>
    <label>내용 :</label>
    <input name="content" type="text" style="width:200px; height:50px;"><br>
    <input type="submit" value="수정">
    </form>
</c:forEach>
</body>
</html>
