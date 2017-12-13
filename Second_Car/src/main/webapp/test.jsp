<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
		
		function getData()
		{
			$.ajax({
				url:"admin/tg_carSelectByIdAction.action",
				type:"post",
				dataType:"json",
				data:{
					id:20
				},
				success:function(data)
				{
					alert(data.car.pic);
				},
				error:function(XMLHttpRequest,textStatus,errorThrown)
				{
					alert(textStatus);
				}
			});
		}
		function getUpdatePrice()
		{
			$.ajax({
				url:"admin/tg_carUpdatePriceAction.action",
				type:"post",
				dataType:"json",
				data:{
					id:0,
					price:10
				},
				success:function(data)
				{
					if(data==null){
						alert("success");
					}
				},
				error:function(XMLHttpRequest,textStatus,errorThrown)
				{
					alert(textStatus);
				}
			});
		}
		
		function admin()
		{
			$.ajax({
				url:"tg_managerAction",
				type:"post",
				dataType:"json",
				data:{
					username:"lxy",
					password:"lxy"
				},
				success:function(data)
				{
					alert(data.msg);
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
    This is my JSP page. <br>
    <form action="admin/tg_carAddAction.action" method="post">
    	ID:<input type="text" name="cid">
    	Date:<input type="text" name="publishTime">
    	<input type="submit" value="submit"/>
    </form>
    <br/>
    <input type="submit" value="getData" onclick="getData()"/><br>
    <input type="submit" value="提交结果" onclick="getUpdatePrice()"/><br>
    <input type="submit" value="submit" onclick="getAdd()"/><br/>
   <input type="submit" value="管理员登录" onclick="admin()"/>
  </body>
</html>
