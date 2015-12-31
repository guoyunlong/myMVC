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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/easyui/demo.css">

<script type="text/javascript" src="<%=basePath%>resource/json/json2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/easyui/jquery.easyui.min.js"></script>

</head>

<body  class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px" >north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:250px;padding:10px;">west content</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:200px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'">
		<table id="dg"></table>
	</div>

</body>

	<script type="text/javascript">
		$('#dg').datagrid({
			rownumbers : true,
			singleSelect : true,
			pagination : true,
			url : 'action.do?action=list&beanName=UserDataProvider',
			method : 'post',
			dataType : 'json',
			loadMsg : '数据加载中请稍后……',
			columns : [ [ {
				field : 'ID',
				title : '编号',
				width : 100
			}, {
				field : 'NAME',
				title : '名称',
				width : 100
			}, {
				field : 'AGE',
				title : '年龄',
				width : 100,
				align : 'right'
			} ] ]
		});
	</script>

</html>