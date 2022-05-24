<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2022/5/24
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result--------</h1>
<h3>text01----${teamName}</h3>
<h3>text02---request作用域获取:----${requestScope.team.teamName}------${requestScope.team.teamId}------${requestScope.team.location}</h3>
<h3>text03---session作用域获取:----${sessionScope.team.teamName}------${sessionScope.team.teamId}------${sessionScope.team.location}</h3>
</body>
</html>
