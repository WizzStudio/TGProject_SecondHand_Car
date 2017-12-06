<html>
	<head>
		<title>index</title>
		<meta charset="utf-8">
		<script type="text/javascript">
	function getData()
	{
		alert("nihao");
		$.ajax({
			type:"post",
			url:"admin/tg_carSelectByIdAction.action",
			dataType:'json',
			data:{},
			success:function(data){ 
				alert(data);
			}
		});
	}	
</script>
	</head>
<body>
<h2>Hello World!</h2>
</body>
</html>
