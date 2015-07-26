<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/7/26
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv=Content-Type content="text/html;charset=utf-8">
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta content=always name=referrer>
    <title>web-test 登录</title>
    <link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/public/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="/css/login/login.css" rel="stylesheet"/>
    <script src="/public/jquery.min.js"></script>
    <script src="/public/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div class="container">
        <div class="user-form">
            <form class="form-signin" action="/login" method="post">

                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" id="inputEmail" class="form-control" placeholder="用 户 名  |  邮 箱" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="密  码" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> 保持登录
                    </label>
                </div>
                <table>
                    <tr >
                        <td id="user-login"><button  class="btn btn-lg btn-success btn-block" type="submit">登录</button></td>
                        <td id="user-regist"><button  class="btn btn-lg btn-success btn-block" type="submit">注册</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
