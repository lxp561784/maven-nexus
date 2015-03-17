<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="title:'功能 導航', border:false,fit:true">
			<div class="easyui-accordion" data-options="fit:true">
				<div title="系統菜單" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
					<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath }/menuAction!tree.action',lines:true,
						onClick:function(node){
							if(node.attributes.url){
								var url = '${pageContext.request.contextPath }'+node.attributes.url;
								addTabs({title:node.text,href:url,closable:true});
							}
							
						}
					"></ul>
				</div>
				<div title="Title2" data-options="iconCls:'icon-reload'" style="padding:10px;">8. content29.</div>
			</div>
		</div>
