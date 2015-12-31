<%@ page pageEncoding="UTF-8"%>

<!-- 自定义新增窗口 -->
<div id="win">
	<form id="ff">
		<table style="border: 10">
			<tr>
				<td>编号:</td>
				<td><input class="easyui-textbox" type="text" name="id"></input>
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input class="easyui-textbox" type="text" name="name"></input>
				</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input class="easyui-textbox" type="text" name="age"></input>
				</td>
			</tr>
		</table>
	</form>

	<div style="text-align:center;padding:5px">
		<a id="saveBtn" href="javascript:void(0)" class="easyui-linkbutton" >保存</a>
		<a id="resetBtn" href="javascript:void(0)" class="easyui-linkbutton" >重置</a>
	</div>
</div>
<script type="text/javascript">

function submitForm(action){
	//$('#ff').form('clear');
	var frm = $("#ff");
    $.ajax({
		type:"post",
		dataType:"json",  
		url:"action.do", 
		data : getActionFormJson(frm,action,"UserDao"),  
		success:function(data){
			if(data.success){
				$.messager.alert('提示信息', data.responseData.responseDetail, 'info');
				$('#win').window('close');
				$('#dg').datagrid('reload');
			}else{
				$.messager.alert('提示信息', data.responseData.responseDetail, 'error');
			}
        }
     });
}
function clearForm(){
	$('#ff').form('clear');
}
</script>
