<!-- 定义取得数据的基础方法 加分页信息 -->

<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript">

$('#dg').datagrid({
	rownumbers : true,
	singleSelect : true,
	pagination : true,
	url : url,
	title : title,
	method : 'post',
	dataType : 'json',
	loadMsg : '数据加载中请稍后……',
	columns : columns,
	toolbar : toolbar
}).datagrid('getPager').pagination({
	pageSize : 10,//每页显示的记录条数，默认为10  
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表  
	beforePageText : '第',//页数文本框前显示的汉字  
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	buttons : buttons
});
</script>
</html>