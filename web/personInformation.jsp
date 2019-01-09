<%@ page import="con.xrz.blog.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%--<div class="container"></div>--%>
<a href="success.jsp">返回主页</a>
<form>
    <table style="margin-left:45%">

        <tr>
            <td>name：</td>
            <td id="name"></td>
        </tr>

        <tr>
            <td>level:</td>
            <td id="level"></td>
        </tr>

        <tr>

            <td>email:</td>
            <td  id="email"></td>
        </tr>
    </table>

</form>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '/info',
            method: 'GET',
            dataType: 'json',
            success(ret) {
                console.log(ret);
                $('#name').html(ret.name);
                $('#level').html(ret.level);
                $('#email').html(ret.email);

            }
        });
    });


</script>
</body>
</html>


