<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function login(){
		$.ajax({
			url:'${pageContext.request.contextPath}/userAction!login.action',
			data:$('#user_login_form').serialize(),
			dataType:'json',
			success:function(data){
				if(data.success){
					$("#user_login_dialog").dialog('close');
					
				}
				$.messager.show({
					title:'提示 ',
					msg:data.msg,
					timeout:5000,
					showType:'slide'
				});
			}
		});
	}
	$(function(){
		$('#user_login_form input').bind('keyup',function(event){
			if(event.keyCode == '13'){
				login();
			}
			
		});
		window.setTimeout(function(){
			$('#user_login_form input[name=name]').focus();
		}, 0);
	});
</script>
 <div id="user_login_dialog" class="easyui-dialog" data-options="title:'登陆',modal:true,closable:false,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){ 
					$('#user_reg_regDialog input').val('');
					$('#user_reg_regDialog').dialog('open');
				}
			},{
				text:'登陆',
				iconCls:'icon-help',
				handler:function(){ 
					login();
				}
			}]">
		<form id="user_login_form" method = "post">
			  	<table>
			  		<tr>
			  			<th width="50px">
			  				登录名
			  			</th>
			  			<td>
			  				<input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名 必填 '"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<th>
			  				密码
			  			</th>
			  			<td>
			  				<input name="pwd" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填  '"/>
			  			</td>
			  		</tr>
			  	</table>
	  	</form>
  </div>