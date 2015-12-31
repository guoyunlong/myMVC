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

<body>

	<table id="dg" title="用户信息列表"
		style="width:700px;height:250px"
		data-options="rownumbers:true,singleSelect:true,pagination:true,url:'action.do?action=list&beanName=UserDataProvider',method:'post',dataType:'json',loadMsg:'数据加载中请稍后……'">
		<thead>
			<tr>
				<th data-options="field:'ID',width:150">编号</th>
				<th data-options="field:'NAME',width:300">名称</th>
				<th data-options="field:'AGE',width:150">年龄</th>
			</tr>
		</thead>
	</table>
	
	<script type="text/javascript">
		$(function() {
			var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
			
			$(pager).pagination({
		        pageSize: 5,//每页显示的记录条数，默认为10  
		        pageList: [5,10,15],//可以设置每页记录条数的列表  
		        beforePageText: '第',//页数文本框前显示的汉字  
		        afterPageText: '页    共 {pages} 页',  
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
			
			pager.pagination({
				buttons : [ {
					iconCls : 'icon-excel',
					text : '导出EXCEL',
					//topText : '导出EXCEL',
					handler : function() {
						alert('excel');
					}
				}]
			});
		});
	</script>
</body>
</html>
