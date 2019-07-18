<%--
  Created by IntelliJ IDEA.
  User: 张德健
  Date: 2019/7/1
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传界面</title>
</head>
<body>
    <h1 style="color: chartreuse;">this is index page!</h1>
    <form action="excel/upload" method="post" enctype="multipart/form-data">
        <label>请上传excel文件</label>
        <input type="file" value="file" name="file"/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
