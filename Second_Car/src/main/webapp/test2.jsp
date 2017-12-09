<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function add()
		{
			$.ajax({
				url:"admin/tg_carAddAction",
				type:"post",
				dataType:"json",
				data:{
				},
				success:function(data)
				{
					
				},
				error:function(XMLHttpRequest,textStatus,errorThrown)
				{
					alert(textStatus);
				}
			});
		}
		function selectAll(){
			$.ajax({
				url:"admin/tg_carSelectAllAction",
				type:"post",
				dataType:"json",
				data:{
				},
				success:function(data)
				{
					alert(data);
					$.each(data,function(n,value){
						alert(value.pic);
					});
				},
				error:function(XMLHttpRequest,textStatus,errorThrown)
				{
					alert(textStatus);
				}
			});
		}
	</script>

  </head>
  
  <body>
    <form action="admin/tg_carAddAction" method="post" enctype="multipart/form-data">
    	<input type="text" name="brand"/><br/>  
    	<input type="text" name="year"/><br/>  
    	<input type="text" name="price"/><br/>  
    	<input type="text" name="info"/><br/>  
    	<input type="file" name="file"/><br/>  
    	<input type="submit" value="submit"/>
    </form>
    
    <input type="submit" value="提交" onclick="selectAll()">
    
    <form action="admin/tg_carUpdatePicAction" method="post" enctype="multipart/form-data">
    	<input type="text" name="id"/><br/>
    	<input type="file" name="file"/><br/>  
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
