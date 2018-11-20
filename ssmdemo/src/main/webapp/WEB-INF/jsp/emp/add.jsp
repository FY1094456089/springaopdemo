<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加雇员</title>
</head>
<body>
<center>
    <h3>用户添加</h3>
    <form action="/emp/addEmp.do" method="post">
        <table border="1" width="400px;">
            <tr align="center"><td>用户名：</td><td><input type="text" name="empno" ></td><tr>
            <tr align="center"><td>职位：</td><td><input type="text" name="job" ></td><tr>
            <tr align="center"><td>薪酬：</td><td><input type="text " name="sal"  ></td><tr>
            <tr align="center"><td colspan="2"> <input type="submit"  value="添加"></td><tr>
        </table>
    </form>
</center>
</body>
</html>
