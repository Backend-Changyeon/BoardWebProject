<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-26
  Time: 오후 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쪽지 쓰기</title>
</head>
<body>
<form action = "/writeMessage", method="post">
    <input name="from_user_id" type="hidden" value="${userID}">
    받는사람 : <input name="to_user_nick_name" value="${to_user_nick_name}">
    내용 : <input name="content" type="text">
    <input type="submit" value="전송">
</form>
</body>
</html>
