<%--
  Created by IntelliJ IDEA.
  User: bin
  Date: 2021/1/21
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<style>
    .padLeft{
        padding-right: 10px;
    }
    .labelcolor{
        background-color: #00FF00
    }
    #box{
        width: 515px;
        height: 430px;
        margin: 15% 40%;
        box-shadow: 5px 5px 10px #00FFFF;
        border-radius: 90px;
        align-content: center;
    }
    .myform{
        position: relative;
        padding: 40px 90px;
    }
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<body>
<div id="box">
<form class="layui-form-pane myform" action="">
    <div class="layui-main">
        <div style="padding: 10px 5px"><p>用户登录</p></div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <i class="layui-icon padLeft">&#xe66f;</i>账号:
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" placeholder="请输入账号">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <i class="layui-icon padLeft">&#xe673;</i>密码:
            </label>
            <div class="layui-input-inline">
                <input type="password" class="layui-input" placeholder="请输入密码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <i class="layui-icon padLeft">&#xe679;</i>验证码:
            </label>
            <div class="layui-input-inline">
                <input type="password" class="layui-input">
            </div>
            <i class="layui-icon">&#xe60d;</i>
        </div>
        <div class="layui-form-item">
<%--            <div class="layui-input-block">--%>
                <button class="layui-btn layui-btn-radius layui-btn-warm" style="width: 120px">登录</button>
                <button class="layui-btn layui-btn-radius layui-btn-warm" style="width: 120px">注册</button>
<%--            </div>--%>
        </div>
    </div>
</form>
</div>
</body>
</html>
