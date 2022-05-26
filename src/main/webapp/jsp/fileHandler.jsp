<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2022/5/25
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件</title>
</head>
<body>
                                                <!--  enctype必须写!  -->
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        请选择文件:<input type="file" name="myFile"/><br/>
        <button type="submit">上传文件</button>
    </form>
                                                <!--  enctype必须写!  -->
    <form action="/file/download" method="post" enctype="multipart/form-data">
        <button type="submit">下载图片</button>
    </form>

</body>
</html>
