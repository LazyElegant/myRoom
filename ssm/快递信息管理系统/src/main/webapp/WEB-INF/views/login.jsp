<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        body {
            background: #f7fafc;
        }
        .log-head {
            margin-top: 130px;
            text-align: center;
        }
        .form-container {
            width: 360px;
            margin: 0 auto;
            font-size: 14px;
            padding: 0 20px 0;
        }

        .form-container h3 {
            margin: 16px 0;
            text-align: center;
            font-size: 20px;
            font-weight: normal;
        }
        .form-container form {
            background: #FFF;
            display: block;
            padding: 10px 20px 0;
            border: 1px solid #e7ebef;
        }
        .form-ctrl {
            position: relative;
            padding: 10px 0;
            border-bottom: 1px solid #e7ebef;
        }
        .form-ctrl input {
            width: 100%;
            background: #FFF;
            outline: none;
            border: none;
            font-size: 16px;
        }
        .btn-submit {
            padding: 0.8em 0;
            display: block;
            width: 100%;
            background: #fd7f24;
            color: #FFF;
            text-align: center;
            font-size: 16px;
            outline: none;
            border: none;
            margin-top: 10px;
            border-radius: 3px;
            cursor: pointer;
        }
        .type {
            padding: 10px;
        }
        .type a {
            padding: 0 16px;
        }

        .fr {
            float: right;
        }
        a {
            outline: none;
            text-decoration: none;
            color: #3278e6;
        }
    </style>
</head>
<body>

<div class="log-head">
    <img src="../img/login_logo_v5.png" alt="">
</div>

<div class="form-container">
    <h3 >账号密码登录</h3>
    <p style="color: red;text-align: center">${msg}</p>
    <form  action="/login" method="post">

        <div class="form-ctrl">
            <input type="text" placeholder="用户名" name="name" >
        </div>
        <div class="form-ctrl">
            <input type="password" placeholder="请输入密码" name="password"  >
        </div>
        <input type="submit" style="display: none;" id="dl" />
    </form>
    <button class="btn-submit" id="submit" >登录</button>
    <div class="type">
        <a  class="fr"  href="/toRegistered">立即注册</a>
    </div>
</div>
</body>
</html>

<script>
    document.getElementById("submit").onclick = function(){
        document.getElementById("dl").click();
    }
</script>