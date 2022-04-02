<%--
  Created by IntelliJ IDEA.
  User: del
  Date: 2022/3/18
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
        color: black;
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

    .content {
        font-size: 38px;
    }

    #read:hover {
        cursor: pointer;
        color: skyblue;
    }

    #nread:hover {
        cursor: pointer;
        color: skyblue;
    }
</style>
<body>
<div class="title">
    <h1>全&nbsp;&nbsp;&nbsp;&nbsp;部&nbsp;&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;件</h1>
</div>
<br>
<p class="user">当前用户:&nbsp;&nbsp;[${sessionScope.currentEmp.name}]</p>

<hr>
<table class="content" style="width:90%;background-color:rgb(230,230,230);text-align: center;border: 1px solid white"
       cellpadding="5"
       cellspacing="1">
    <tr bgcolor="black" style="color:white;height: 50px">
        <th>选择</th>
        <th>序号</th>
        <th>标题</th>
        <th>发送人</th>
        <th>日期时间</th>
        <th hidden>邮件id</th>
        <th>已读/未读</th>
        <th>操作</th>
    </tr>
    <c:if test="${sessionScope.AllMail ne null}">
        <c:forEach items="${sessionScope.AllMail}" var="mail" varStatus="sta">
            <c:if test="${mail.deleted eq '0'}">
                <tr style="background-color:white;height: 40px">
                    <td><input type="checkbox"></td>
                    <td></td>
                    <td>${mail.title}</td>
                    <c:forEach items="${sessionScope.AllEmp}" var="emp">
                        <c:if test="${mail.senderid eq emp.id}">
                            <td>${emp.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${mail.sendtime}</td>
                    <td hidden>${mail.id}</td>
                    <c:if test="${mail.checkid eq '1'}">
                        <td>已读</td>
                    </c:if>
                    <c:if test="${mail.checkid eq '0'}">
                        <td style="color: red">未读</td>
                    </c:if>
                    <c:if test="${mail.checkid eq '1'}">
                        <td><p id="nread">标为未读</p></td>
                    </c:if>
                    <c:if test="${mail.checkid eq '0'}">
                        <td><p id="read">设为已读</p></td>
                    </c:if>
                </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>
</body>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    var oT = document.querySelector('.content');
    var aTr = document.querySelectorAll("tr");
    for (var i = 0; i < aTr.length; i++) {
        var aTd = aTr[i].children;
        aTd[1].innerText = i;
        aTr[0].children[1].innerText = "序号";
    }

    var aRead = $('.read');
    aRead.click(function () {
        $.post('allMailServletAjax?read=' + this.parentNode.parentNode.children[5].innerText, function (data) {
            if (data = "success") {
                this.innerText = "标为未读";
                this.parentNode.parentNode.children[6].innerText = "已读";
            } else {
                alert("失败");
            }
        })
    })

    var aNread = $('.nread');
    aNread.click(function () {
        $.set('allMailServletAjax?nread=' + this.parentNode.parentNode.children[5].innerText, function (data) {
            if (data = "success") {
                this.innerText = "设为已读";
                this.parentNode.parentNode.children[6].innerText = "未读";
                this.parentNode.parentNode.children[6].style = "color:red";

            }
        })
    })
</script>
</html>
