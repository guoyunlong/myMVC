<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>TEST</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.8.3.js"></script>

<script type="text/javascript">
	function submitll() {
		alert($(":input")[0].type);
	}
</script>

</head>

<body>
	<form>
	
		<button onclick="submitll();">提交</button>
		姓名:<input name="name" id="name" type="text" value="11111111111"> <br>
		 年龄:<input type="text" value=""><br>
	</form>
</body>
</html>
