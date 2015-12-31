<!-- 定义页面主体布局 -->

<%@ page pageEncoding="UTF-8"%>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px" >north region
		<!-- 一个万能的默认关闭窗口 -->
		<div id="winNorth" class="easyui-window" data-options="closed:true,title:'BasicWindow',iconCls:'icon-save'" style="width:800px;height:600px;padding:10px;">
		</div>
	</div>
	<div data-options="region:'west',split:true,title:' '" style="width:250px;padding:10px;">
		树型菜单
		<!-- 一个万能的树形菜单 -->
		<ul id="tt" class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,checkbox:true"></ul>
	</div>
	<div data-options="region:'east',split:true,collapsed:false,title:' '" style="width:200px;">
		<!-- 一个万能的面板 -->
		<div id="winNorth" class="easyui-panel" style="width:100%;height:100%;">
		</div>
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center'">
		<table id="dg" style="width:100%;height:100%;"></table>
	</div>
</body>
