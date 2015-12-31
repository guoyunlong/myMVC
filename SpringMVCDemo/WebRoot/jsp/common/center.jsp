<!-- 定义页面主体布局 -->

<%@ page pageEncoding="UTF-8"%>
<body  class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px" >north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:250px;padding:10px;">
		<ul id="tt"></ul>
		<script type="text/javascript">
			
		</script>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:200px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center'">
		<table id="dg" style="width:100%;height:100%;"></table>
	</div>
</body>
