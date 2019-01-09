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
    <title>登录界面</title>
</head>
<body>
<div class="header-back">欢迎回来 <span id="username"><%=((User) request.getSession().getAttribute("currentUser")).getName()%></span><a href="personInformation.jsp" class="person_info">[个人资料]</a></div>
<div class="clearfix"><hr></div>

</body>
</html>
