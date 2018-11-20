<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/8
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>用户修改</h3>
    <form action="/emp/update.do" method="post">
        <table border="1" width="400px;">
            <tr align="center"><td>用户名：</td><td><input type="text" name="empno" id="empno" value="${getById.EMPNO}" ></td><tr>
            <tr align="center"><td>职位：</td><td><input type="text" name="job" id="job" value="${getById.JOB}"></td><tr>
            <tr align="center"><td>薪酬：</td><td><input type="text " name="sal" id="sal" value="${getById.SAL}" ></td><tr>
            <tr align="center"><td colspan="2"> <input type="submit"  value="提交"></td><tr>
        </table>
    </form>
</center>
</body>
</html>
