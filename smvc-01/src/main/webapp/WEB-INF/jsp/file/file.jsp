<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胜胜
  Date: 2021/12/30
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/">返回首页</a>
</h2>
<br>
    <h3>文件下载列表</h3>
    <c:forEach items="${requestScope.list}" var="f">
        <a href="downLoad?fileName=${f}">${f}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下载</a>
        <br>
    </c:forEach>

</body>
</html>
