<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>邮件系统主页</title>
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

    .bdr {
        border-radius: 6px;
        height: 30px;
        font-size: 26px;
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

    hr {
        display: inline-block;
        width: 100%;
        height: 2px;
    }

    .loginbox {
        position: absolute;
        margin-top: 20px;
        margin-left: 20%;
        padding: 150px 30px 30px;
        width: 350px;
        height: 600px;
        font-size: 28px;
        border: 2px solid;
        border-radius: 8px;
        color: #368;
    }

    .login {
        font-size: 24px;
        color: black;
    }
</style>
<body>
<div class="title">
    <h1>企业内部邮件管理系统</h1>
</div>
<br>
<hr>
<div class="loginbox">
    <form class="login" action="loginServlet" method="post">
        <label>用户名:</label><input class="bdr" name="uname" type="text" value="请输入登录用户名"
                                  onfocus="if (value=='请输入登录用户名'){value=''}"
                                  onblur="if (value==''){value='请输入登录用户名'}"><br><br>
        <label>密&nbsp;&nbsp;&nbsp;码:</label><input class="bdr" name="upwd" type="password" value="请输入密码"
                                                   onfocus="if (value=='请输入密码'){value=''}"
                                                   onblur="if (value==''){value='请输入密码'}"><br><br>

        <input style="font-size: 24px" type="submit" value="登录login">&nbsp;&nbsp;<input type="checkbox"
                                                                                        name="savepwd">保存密码<br><a
            href="">没有账号,去注册</a><br>
        <% String mess = request.getParameter("loginfaild");
            if (mess != null && mess.equals("error")) {
        %>
        <label style="color:red"> 登录失败,用户名或密码不存在</label>
        <%
            }
        %>
    </form>
</div>
</body>

</html>