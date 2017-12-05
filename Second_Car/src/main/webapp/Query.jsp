<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body bgcolor="#D9DFAA" >  
  <table border="1">  
    <tr>  
        <td>车号</td>  
        <td>图片</td>  
        <td>种类</td>  
        <td>日期</td>  
        <td>价格</td>  
        <td>发布时间</td>  
    </tr>  
    <s:iterator value="#session.cars" var="cars">
    	<tr>
    		 <td><s:property value="#cars.cid"></s:property></td>  
        	 <td><s:property value="#cars.brand"></s:property></td>  
    	</tr>
    </s:iterator>
    <s:set var="page" value="#request.page"/>
    	<tr>
    		<td colspan="2">
    			当前：<s:property value="#page.currentPage" />，共<s:property value="#page.totalPage"/>
    		</td>
    	</tr>
  </table>  
  </body>  
</html>