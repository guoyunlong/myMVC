<!-- 最基础的列表页  -->
<!-- 
必须重新定义以下参数
	columns = [[{},{}]]
	url = 'action.do?action=action&beanName=beanName'
	title = 'titleName'
 可以重新定义
 	toolbar
 	buttons
 -->

<%@ page pageEncoding="UTF-8"%>
<jsp:include page="../../common/header.jsp" flush="false"></jsp:include>
<jsp:include page="../../common/center.jsp" flush="false"></jsp:include>
<jsp:include page="./form.jsp" flush="false"></jsp:include>
<script type="text/javascript">
	columns = [ [ {
		field : 'ck',
		checkbox : true
	}, {
		field : 'id',
		title : '编号',
		align : 'center',
		width : 170
	}, {
		field : 'name',
		title : '名称',
		align : 'center',
		width : 400
	}, {
		field : 'age',
		title : '年龄',
		align : 'center',
		width : 150
	} ] ];

	url = 'action.do?action=list&beanName=UserDataProvider';
	title = '用户信息列表';

	toolbar = [ '-', {
		text : '增加',
		iconCls : 'icon-add',
		handler : function() {

			$('#ff').form('clear');
			
			$('#saveBtn').bind('click', function(){
				submitForm("add");
		    });
		    $('#resetBtn').bind('click', function(){
		    	clearForm();;
		    });
			$('#win').window({
				title : '用户新增',
				width : 600,
				height : 400,
				modal : true
			});
		}
	}, '-', {
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
			   $.ajax({
			         type:"post",
			         dataType:"json",  
			         url:"action.do", 
			         data : getActionJsonAdd(row,"loadid","UserDao"),   
			         success:function(data){
						if(data.success){
							$('#saveBtn').bind('click', function(){
								submitForm("edit");
						    });
						    $('#resetBtn').bind('click', function(){
						    	clearForm();;
						    });

							$('#ff').form('load', data.responseData);
							$('#win').window({
								title : '用户修改',
								width : 600,
								height : 400,
								modal : true
							});
						}
			        }
			     });
			} else {
				$.messager.alert('提示信息', '请先选择要更新的记录。', 'info');
			}
		}
	}, '-', {
		text : '删除',
		iconCls : 'icon-cut',
		handler : function() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$.ajax({
			         type:"post",
			         dataType:"json",  
			         url:"action.do", 
			         data : getActionJsonAdd(row,"delete","UserDao"),  
			         success:function(data){
			        	 //if(data.success){
			        		 $.messager.alert('提示信息', data.responseData.responseDetail, 'info');
			        		 if(data.success){
			        		 	$('#dg').datagrid('reload');
			        		 }
			        	 //}
			        	 //alert(JSON.stringify(data));
			        }
			     });
			 } else {
				$.messager.alert('提示信息', '请先选择要更新的记录。', 'info');
			}
		}
	}, '-' ];
</script>

<jsp:include page="../../common/footer.jsp" flush="false"></jsp:include>