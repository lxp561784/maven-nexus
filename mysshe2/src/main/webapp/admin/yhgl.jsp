<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
    	<script type="text/javascript">
    		$(function(){
    			$('#admin_yhgl_datagrid').datagrid({
    				url:'${pageContext.request.contextPath}/userAction!datagrid.action',
    				fit : true,
    				fitColumns : true,
    				border : false,
    				pagination : true,
    				idField : 'id',
    				sortName:'name',
    				columns:[[ {
    						field:'id',
   				     		title:'編號',
    				      	width:150,
    				      	hidden:true
    				      },{
    				   		field:'name',
    				   		title:'登陸名稱',
    				   		width:150,
    				   		sortable:true
    				   		
    				   	}, 	{
    				   		field:'pwd',
    				   		title:'密碼',
    				   		width:150,
    				   		align:'right',
    				   		formatter:function(value,row,index){
    				   			return '<span title="'+value+'">'+value+'</span>';
    				   		}
    				   	}, 	{
    				   		field:'createdate',
    				   		title:'創建時間',
    				   		width:150,
    				   		align:'right',
    				   		sortable:true
    				   	}, 	{
    				   		field:'modifydate',
    				   		title:'修改時間',
    				   		width:150,
    				   		align:'right'
    				   	}]]
    			,
    				   	toolbar:'#admin_yhgl_toolbar'
    			
    			});
    		});
    		
    		function searchFun(){
    			$("#admin_yhgl_datagrid").datagrid("load",{
    				name:$('#admin_yhgl_toolbar input[name=name]').val()
    			});
    		}
    		function cleanFun(){
    			$('#admin_yhgl_toolbar input[name=name]').val("");
    			$("#admin_yhgl_datagrid").datagrid("load",{});
    		}
    	</script>
    	<table id="admin_yhgl_datagrid">
    	</table>
    	
    	<div id="admin_yhgl_toolbar">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="float:left">编辑 </a>
				<div class="datagrid-btn-separator"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">帮助 </a>
			<input name="name"/>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun()">查询 </a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clean',plain:true" onclick="cleanFun()">清空</a>
</div>
    	
