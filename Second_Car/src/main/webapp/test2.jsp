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
					alert(data.msg);
					
				},
				error:function(XMLHttpRequest,textStatus,errorThrown)
				{
					alert(textStatus);
				}
			});
		}
		function deletePic() {
			$.ajax({
                url:"admin/tg_carDeletePicAction",
                type:"post",
                dataType:"json",
                data:{
                    pic:"http://119.23.75.180:8080/SecondCar/TG_Photo/IGS09651F94M_0.jpg"
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
    <form action="admin/tg_carAddAction" method="post" enctype="multipart/form-data">
    	<input type="text" name="brand"/><br/>  
    	<input type="text" name="year"/><br/>  
    	<input type="text" name="price"/><br/>  
    	<input type="text" name="info"/><br/>  
    	<input type="file" name="files" multiple/><br/>
    	<input type="submit" value="submit"/>
    </form>
	<form action="admin/tg_carAddAction" method="post" enctype="multipart/form-data">
		<input type="text" name="brand"/><br/>
		<input type="text" name="year"/><br/>
		<input type="text" name="price"/><br/>
		<input type="text" name="info"/><br/>
		<input type="file" name="file"/><br/>
		<input type="file" name="file1"/><br/>
		<input type="file" name="file2"/><br/>
		<input type="file" name="file3"/><br/>
		<input type="submit" value="submit"/>
	</form>
    
    <input type="submit" value="提交" onclick="selectAll()">
    
    <form action="admin/tg_carUpdatePicAction" method="post" enctype="multipart/form-data">
    	<input type="text" name="id"/><br/>
    	<input type="file" name="file"/><br/>  
    	<input type="submit" value="submit"/>
    </form>
    <form action="admin/tg_carUpdateAllAction" method="post" enctype="multipart/form-data">
    	<input type="text" name="id"><br/>
    	<input type="text" name="brand"/><br/>  
    	<input type="text" name="year"/><br/>  
    	<input type="text" name="price"/><br/>  
    	<input type="text" name="info"/><br/>  
    	<input type="file" name="pic"/><br/>  
    	<input type="file" name="pic1"/><br/>
    	<input type="file" name="pic2"/><br/>
    	<input type="file" name="pic3"/><br/>
    	<input type="submit" value="submit"/>
    </form>

  <input type="submit" value="删除" onclick="deletePic()">
  </body>
</html>
