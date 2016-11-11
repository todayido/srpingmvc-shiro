<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/28
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
This is UserList page...<br>
获取用户信息：<br>
<c:forEach items="${userList}" var="user">
    ${user.username}<br>
</c:forEach>
</body>
</html>
