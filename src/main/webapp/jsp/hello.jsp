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
  <h3>9.获取集合类型的参数</h3>
  <form action="/param/text09" method="post">
    球队名称1: <input type="text" name="teamList[0].teamName" /><br/>
    球队名称2: <input type="text" name="teamList[1].teamName" /><br/>
    球队名称3: <input type="text" name="teamList[2].teamName" /><br/>
    球队id1:  <input type="text" name="teamList[0].teamName" /><br/>
    球队id2:  <input type="text" name="teamList[1].teamName" /><br/>
    球队id3:  <input type="text" name="teamList[2].teamName" /><br/>
    <button type="submit">提交</button>
  </form>


  <h3>8.获取集合类型的参数</h3>
  <form action="/param/text08" method="post">
    球队名称1: <input type="text" name="teamName" /><br/>
    球队名称2: <input type="text" name="teamName" /><br/>
    球队名称3: <input type="text" name="teamName" /><br/>
    <button type="submit">提交</button>
  </form>


  <h3>7.获取数组类型的参数</h3>
  <form action="/param/text07" method="post">
    球队名称1: <input type="text" name="teamName" /><br/>
    球队名称2: <input type="text" name="teamName" /><br/>
    球队名称3: <input type="text" name="teamName" /><br/>
    <button type="submit">提交</button>
  </form>


  <h3>6.获取日期类型的参数</h3>
  <form action="/param/text06" method="post">
    球队id:  <input type="text" name="teamId" /><br/>
    球队名称: <input type="text" name="teamName" /><br/>
    球队位置: <input type="text" name="Location" /><br/>
    创建日期: <input type="text" name="createTime" /><br/>
    <button type="submit">提交</button>
  </form>

  <h3>5.直接使用URL地址传参</h3>

  <br/>
  <br/>
  <br/>

  <h3>3.请求参数和方法名称不一致</h3>
  <form action="/param/text03" method="post">
    球队id:  <input type="text" name="teamId" /><br/>
    球队名称: <input type="text" name="teamName" /><br/>
    球队位置: <input type="text" name="Location" /><br/>
    <button type="submit">提交</button>
  </form>

  <br/>
  <br/>
  <br/>

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
