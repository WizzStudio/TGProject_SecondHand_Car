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
				url:"admin/tg_carSelectByIdAction",
				type:"post",
				dataType:"json",
				success:function(data)
				{
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
		
		function getAdd()
		{
			$.ajax({
				url:"admin/tg_carAddAction.action",
				type:"post",
				dataType:"json",
				data:{
					cid:7,
					pic:"test",
					brand:"TGP",
					year:1997,
					price:70,
					publishTime:"2017/12/08"
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
    <input type="submit" value="submit" onclick="getAdd()"/>
  </body>
</html>
