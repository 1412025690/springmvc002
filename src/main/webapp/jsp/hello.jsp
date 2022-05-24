<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2022/5/24
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
  <h3>2.使用对象接收多个参数</h3>
  <form action="/param/text02" method="post">
    球队id:  <input type="text" name="teamId" /><br/>
    球队名称: <input type="text" name="teamName" /><br/>
    球队位置: <input type="text" name="Location" /><br/>
    <button type="submit">提交</button>
  </form>

  <br/>
  <br/>
  <br/>
  <h3>1.直接使用方法来接收参数</h3>
  <form action="/param/text01" method="post">
    球队id:  <input type="text" name="teamId" /><br/>
    球队名称: <input type="text" name="teamName" /><br/>
    球队位置: <input type="text" name="teamLocation" /><br/>
    <button type="submit">提交</button>
  </form>
</body>
</html>
