<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-26
  Time: 오후 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쪽지 쓰기</title>
</head>
<body>
<form action = "/writeMessage", method="post">
    받는사람 : <input name="to_account" type="email" value="${to_account}">
    <input name="from_account" type="hidden" value="${user}">
    내용 : <input name="content" type="text">
    <input type="submit" value="전송">
</form>
</body>
</html>
