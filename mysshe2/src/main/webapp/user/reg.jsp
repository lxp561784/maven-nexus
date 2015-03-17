<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#user_reg_regForm').bind('keyup',function(event){
			if(event.keyCode == '13'){
				regUser();
				
			}
		});
	});
	
	function regUser(){
		/*
		$('#index_regForm').form('submit',{
			url:'${pageContext.request.contextPath}/userAction!reg.action ',
			onSubmit: function(){
			},
			success:function(data){
				var obj = jQuery.parseJSON(data);
				if(obj.success){
					$('#index_regDialog').dialog('close');
					$.messager.show({
						title:'提示 ',
						msg:obj.msg,
						timeout:5000,
						showType:'slide'
						
					});
				}
			}
		});
		*/
		if($('#user_reg_regForm').form('validate')){
			$.ajax({
				url:'${pageContext.request.contextPath}/userAction!reg.action',
				data:$('#user_reg_regForm').serialize(),
				dataType:'json',
				success:function(obj){
					if(obj.success){
						$('#user_reg_regDialog').dialog('close');
					}
					$.messager.show({
						title:'提示 ',
						msg:obj.msg,
						timeout:5000,
						showType:'slide'
					});
				}
			});
		}else{
			alert("验证失败！");
		}
		
	}
</script>

<div id="user_reg_regDialog" style="width:250px" class="easyui-dialog" data-options="title:'注册 ',modal:true,closed:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					regUser();
				 }
			}]" >
<form id="user_reg_regForm" method="post">
  	<table>
  		<tr>
  			<th width="50px">
  				登录名
  			</th>
  			<td>
  				<input name="name" class="easyui-validatebox" data-options="required:true "/>
  			</td>
  		</tr>
  		<tr>
  			<th>
  				密码
  			</th>
  			<td>
  				<input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true "/>
  			</td>
  		</tr>
  		<tr>
  			<th>
  				重复密码
  			</th>
  			<td>
  				<input name="rePwd" type="password"class="easyui-validatebox" data-options="required:true,validType:'eqPassword[\'#pwd\']' "/>
  			</td>
  		</tr>
  	</table>
  	</form>
  </div>
	