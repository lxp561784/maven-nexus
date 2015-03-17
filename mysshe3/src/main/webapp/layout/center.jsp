<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function addTabs(opts){
		var t = $("#index_centerTabs");
		if(t.tabs("exists",opts.title)){
			t.tabs("select",opts.title);
		}else{
			t.tabs("add",opts);
		}
		
	}

</script>
<div id="index_centerTabs" class="easyui-tabs" data-options="fit:true,border:false">
  		<div title="首页"></div>
  	</div>
