<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <title>注册界面</title>
    <style type="text/css">
        body {
            background-position: center;
            background-repeat: no-repeat;
        }

    </style>
</head>
<body>
<script src="jquery.js"></script>
<div style="text-align:center;margin-top:120px">
    <h1>请注册</h1>
    <form action="/register" method="post">
        <table style="margin-left:45%">
            <tr>
                <td>登录名：</td>
                <td><input id="login_name" onkeyup="check()" name="name" type="text" size="20"></td>
                <td><p id="name_error" style="color: red;display:none">该用户名已被注册</p></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input id="login_password" onkeyup="check_password()"  name="password" type="password" size="20"></td>
                <td><p id="password_error" style="color: red;display:none" >密码不能为空</p></td>
            </tr>
        </table>
        <input type="submit" value="注册" id="submit" disabled="disabled">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="Login.jsp">登录</a>
</div>
</body>
<script>
    function check_password() {
        if($('#login_password').val()!=''){
            document.getElementById('password_error').style.display = "none";
            $('#submit').removeAttr("disabled");
        }else{
            document.getElementById('password_error').style.display = "block";
            $('#submit').attr({"disabled":"disabled"});
        }
    }
    function check() {
        $.ajax({
            url: "/check",//传入的servlet和对应的方法
            type: "post",//提交方式
            dataType: "text",
            data: {
                "username": $('#login_name').val()
            },//传入的数据为输入的登录名
            success: function (data) {//得到servlet传回的数据后，进行处理
                console.log("data is :", data);
                if (data === 'true') {
                    $('#name_error')[0].style.display = "block";
                    $('#submit').attr({"disabled":"disabled"});
                } else {
                    $('#name_error')[0].style.display = "none";
                    check_password();
                }

            },
            error: function () {
                alert(" server error")
            }
        })
    }
</script>
</html>
