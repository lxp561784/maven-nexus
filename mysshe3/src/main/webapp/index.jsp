<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"	src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script	type="text/javascript" 	src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jslib/utils.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css" type="text/css"></link>

</head>

<body class="easyui-layout">
  <div data-options="region:'north'" style="height:60px"></div>
  <div data-options="region:'south',title:'south title'" style="height:40px"></div>
  <div data-options="region:'west' ,split:true" style="width:200px">
  	<jsp:include page="layout/west.jsp"></jsp:include>
  </div>
  <div data-options="region:'east',title:'east title'" style="width:200px"></div>
  <div data-options="region:'center',title:'center title'" >
  	<jsp:include page="layout/center.jsp"></jsp:include>
  </div>
	
	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/reg.jsp"></jsp:include>
 
  
  
	 
</body>
</html>
