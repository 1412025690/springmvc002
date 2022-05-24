<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2022/5/24
  Time: 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>index-------${teamName}</h1>

    <img src="/images/txcat.jpg" title="服不服?!" />


<%--地址栏默认提交方式是git提交 如果直接使用地址栏输入地址会报405  405:一般指提交方式映射不上 例: 后台是post提交方式 前端使用git 就报405--%>
    <form action="/team/update.do" method="post">
        <button type="submit">post提交到update.do</button>
    </form>
    <form action="/team/add.do" method="get">
        <button type="submit">post提交到add.do</button>
    </form>
</body>
</html>
