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

<script type="text/javascript" src="<%=basePath%>resource/js/json/json2.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-1.8.3.js"></script>

<script type="text/javascript">


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

function getQueryFormJson(frm,action,beanName,start,limit) {
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
	o["start"]=start;
	o["limit"]=limit;
	return o;
}

function sendRequest(){

	var frm = $("#formid");
    $.ajax({
         type:"post",
         dataType:"json",  
         url:"action.do", 
         data : getActionFormJson(frm,"add","UserDao"),  
         //data:{"action":"add","beanName":"UserDao"}+getFormJson(frm),  
         success:function(data){
        	 $("#msg").html(JSON.stringify(data));
        }
     });
}
</script>

</head>

<body>
	<form id="formid">
	
		编号:<input name="id" id="id" type="text" value="3"> <br>
		姓名:<input name="name" id="name" type="text" value="111"> <br>
		 年龄:<input name="age" id="age" type="text" value="22"><br>
		 
		<button onclick="sendRequest();">提交</button><br>
		
		<span id="msg"></span>
	</form>
</body>
</html>
