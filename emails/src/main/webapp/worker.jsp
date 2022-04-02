<%--
  Created by IntelliJ IDEA.
  User: del
  Date: 2022/3/14
  Time: 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    body {
        width: 100%;
        height: 1000px;
        background: url("imgs/bgimg.jpg") no-repeat;
        background-size: 100% 100%;
    }

    a {
        text-decoration: none;
    }


    .title {
        display: inline-block;
        height: 150px;
        width: 100%;
    }

    h1 {
        display: inline-block;
        height: 200px;
        line-height: 150px;
        margin-left: 25%;
        font-size: 50px;
        font-weight: bold;
        color: #368;
    }

    .user {
        float: right;
        font-size: 28px;
    }

    hr {
        display: inline-block;
        width: 100%;
        height: 2px;
    }

    .buttonbox {
        margin-top: 50px;
        margin-left: 80px;
        border: 2px solid;
        border-radius: 10px;
        width: 300px;
        height: 200px;
        text-align: center;
        vertical-align: middle;
    }

    a:hover {
        cursor: pointer;
        transform: scale(1.2);
    }

    a {
        display: inline-block;
    }
</style>
<body>
<div class="title">
    <h1>企业内部邮件管理系统</h1>
</div>
<br>
<p class="user">当前用户:&nbsp;&nbsp;[${sessionScope.currentEmp.name}]</p>
<hr>
<a href="allMailServlet?id=${sessionScope.currentEmp.id}">
    <div class="buttonbox">
        <p>所有邮件</p>
    </div>
</a>

<a>
    <div class="buttonbox">
        <p>发送邮件</p>
    </div>
</a>
</body>
</html>
