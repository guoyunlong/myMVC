<%@ page pageEncoding="UTF-8"%>

<!-- 自定义新增窗口 -->
<div id="winEdit">
	<form id="ffEdit">
		<table style="border: 10">
			<tr>
				<td>编111111111号:</td>
				<td><input class="easyui-textbox" type="text" name="id"></input>
				</td>
			</tr>
			<tr>
				<td>姓1111111名:</td>
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
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">Submit</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" 
			onclick="clearForm()">Clear</a>
	</div>
</div>
<script type="text/javascript">


function submitForm(){

	var frm = $("#ffEdit");
    $.ajax({
         type:"post",
         dataType:"json",  
         url:"action.do", 
         data : getActionFormJson(frm,"edit","UserDao"),  
         success:function(data){
        	 //if(data.success){
        		 $.messager.alert('提示信息', data.responseData.responseDetail, 'info');
        		 if(data.success){
        		 	$('#winEdit').window('close');
        		 	$('#dg').datagrid('reload');
        		 }
        	 //}
        	 //alert(JSON.stringify(data));
        }
     });
}

function clearForm(){
	$('#ffEdit').form('clear');
}
</script>
