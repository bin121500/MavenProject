<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<style>
    .padLeft {
        padding-right: 10px;
    }

    .labelcolor {
        background-color: #00FF00
    }

    #box {
        width: 515px;
        height: 650px;
        margin: 5% 40%;
        box-shadow: 5px 5px 10px #00FFFF;
        border-radius: 90px;
        align-content: center;
    }

    .myform {
        position: relative;
        padding: 40px 90px;
    }
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" charset="UTF-8"></script>
<body>
<script>
    layui.use('form', function () {
        var form = layui.form;

        form.on('submit(go)', function(data){
            // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            // return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });

        form.verify({
            account: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }
                //如果不想自动弹出默认提示框，可以直接返回 true，这时你可以通过其他任意方式提示（v2.5.7 新增）
                if(value === 'xxx'){
                    alert('用户名不能为敏感词');
                    return true;
                }
            }
            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,pwd: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });

        form.on('select(select_xueli)', function(data){
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
        });
    });
</script>
<div id="box">
    <form class="layui-form layui-form-pane myform" action="../UserServlet?" method="post">
        <div class="layui-main" style="margin: -9px 4px;">
            <p style="padding-left:90px;padding-bottom:20px;font-size:30px">用户注册</p>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <i class="layui-icon padLeft">&#xe66f;</i>用户名:
                </label>
                <div class="layui-input-inline">
                    <input type="hidden" class="layui-input" name="methodName" lay-verify="methodName" value="login">
                    <input type="text" class="layui-input" name="account" lay-verify="account"required placeholder="请输入账号">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <i class="layui-icon padLeft">&#xe673;</i>密码:
                </label>
                <div class="layui-input-inline">
                    <input type="password" class="layui-input" lay-verify="pwd" required placeholder="请输入密码">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <i class="layui-icon padLeft">&#xe673;</i>确认
                </label>
                <div class="layui-input-inline">
                    <input type="password" class="layui-input" required placeholder="请输入密码">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <input type="radio" name="sex" value="男" title="男" style="margin-top:10px;margin-left:35px">
                    <input type="radio" name="sex" value="女" title="女" checked="true" style="margin-left:25px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <i class="layui-icon padLeft">&#xe618;</i>邮箱
                </label>
                <div class="layui-input-inline">
                    <input type="email" class="layui-input" name="email" required lay-verify="email"placeholder="请输入邮箱">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学历</label>
                <div class="layui-input-inline">
                    <select name="xueli" lay-filter="select_xueli">
                        <option value="本科">本科</option>
                        <option value="专科">专科</option>
                        <option value="高职">高职</option>
                        <option value="小学">小学</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职业</label>
                <div class="layui-input-inline">
                    <select name="zhiye">
                        <option value="程序员">程序员</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-radius layui-btn-warm" lay-submit lay-filter="go" style="width: 120px">注册</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
