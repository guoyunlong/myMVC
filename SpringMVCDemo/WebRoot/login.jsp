<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <!-- 
    <a href="action.do?action=list">LIST</a>
    <a href="action.do?action=add">ADD</a>
    <a href="action.do?action=update">UPDATE</a>
    <a href="action.do?action=delete">DELETE</a>
    <a href="action.do?action=loadid">LOADID</a>
    <a href="login.do?action=in">登陆</a> -->
    
    <form id="loginIn" action="login.do?action=in">
    	<input type="hidden" id="action" name="action" value="loginIn">
    	<input type="text" id="userName" name="userName" value="admin">
    	<input type="password" id="userPassword" name="userPassword" value="admin">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
