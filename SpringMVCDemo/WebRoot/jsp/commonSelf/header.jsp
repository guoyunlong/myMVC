<!-- 头部页面 设置基本信息 导入其他页面用到的文件 -->
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

<script type="text/javascript">
var columns = [[{}]];
var toolbar = [ {
	text : '增加',
	iconCls : 'icon-add',
	handler : function() {
		alert('add');
	}
}, {
	text : '编辑',
	iconCls : 'icon-edit',
	handler : function() {
		alert('edit');
	}
} ];
var url = '';
var title = '';
var buttons = [{
	iconCls : 'icon-excel',
	text : '导出EXCEL',
	handler : function() {
		alert('excel');
	}
},'-'];

//将表单数据转换成JSON
function getActionFormJson(frm,action,beanName) {
	var o = {};
	var a = $(frm).serializeArray();
	$.each(a, function () {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	o["action"]=action;
	o["beanName"]=beanName;
	
	return o;
}

//将表单数据转换成JSON
function getActionJsonAdd(json,action,beanName) {
	json["action"]=action;
	json["beanName"]=beanName;
	return json;
}
</script>

</head>