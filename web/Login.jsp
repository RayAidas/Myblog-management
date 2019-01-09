<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录界面</title>
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
    <h1>请登录</h1>
    <form action="/login" method="post">
        <table style="margin-left:45%">
            <%--<marquee width="200"scrolldelay="250">用户登录</marquee>--%>
            <%--<caption style="margin-left: 3px;text-align: left;">用户注册</caption>--%>

            <tr>
                <td>登录名：</td>
                <td><input name="username" onchange="change()" type="text" size="21" id="loginname"></td>
                <td><p id="password-error" style="color: red;display:none">该用户不存在</p></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="21" id="loginpass"></td>
            </tr>
        </table>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
    <script>
        function change() {
            $.ajax({
                url: "/check",//传入的servlet和对应的方法
                type: "post",//提交方式
                dataType: "text",
                data: {
                    "username": $('#loginname').val()

                },//传入的数据为输入的登录名
                success: function (data) {//得到servlet传回的数据后，进行处理
                    console.log("data is :",data);
                    if (data === 'true') {
                        $('#password-error')[0].style.display = "none";
                    } else {
                        $('#password-error')[0].style.display = "block";
                    }
                },
                error: function () {
                    alert("server error")
                }
            });
        }
    </script>
    <br>
    <a href="Register.jsp">注册</a>
</div>
</body>


</html>
