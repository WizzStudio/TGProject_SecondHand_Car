<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="admin/tg_carSelectByIdAction.action">
		<input type="text" name="id">
		<input type="submit" name="提交">
	</form>
	
	<form action="admin/tg_carSelectAllAction.action">
		<input type="submit" name="提交">
	</form>
	
	<form action="admin/tg_carDeleteByIdAction.action">
		<input type="text" name="id">
		<input type="submit" name="提交">
	</form>
	
	<form action="admin/tg_carDeleteAllAction.action">
		<input type="submit" name="提交">
	</form>
	更新价格
	<form action="admin/tg_carUpdatePriceAction.action">
		<input type="text" name="car.cid">
		<input type="text" name="car.price">
		<input type="submit" name="提交">
	</form>
	
	<form action="admin/tg_carUpdateBrandAction.action">
		<input type="text" name="car.cid">
		<input type="text" name="car.brand">
		<input type="submit" name="提交">
	</form>
	
	<form action="admin/tg_carPagerAction.action">
		<input type="submit" name="提交">
	</form>
	<form action="admin/tg_carUpdatePicAction.action" method="post" enctype="multipart/form-data" >
			id:<input type="text" name="id"/>   
         	请选择需要上传的文件：<input type="file" id="dofile" name="file"/><br />  
         	<input type="submit" value="upload"/>
     </form> >
</body>
</html>