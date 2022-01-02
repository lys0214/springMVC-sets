<%--
  Created by IntelliJ IDEA.
  User: 胜胜
  Date: 2021/12/30
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<h2>
    <a href="/">返回首页</a>
</h2>
<br>

<form action="/upload" enctype="multipart/form-data" method="POST">
    <input type="file" name="file"/>
    <br>
    <input type="submit" value="上传">
    <p>${msg}</p>
</form>
</body>
</html>
