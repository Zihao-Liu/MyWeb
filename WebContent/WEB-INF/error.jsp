<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content= "5;index.jsp"  http-equiv= "Refresh"  />  
<title>错误页面</title>

       
</head>
<body>
	对不起出现错误，<b style=color:blue><span id=jump>5</span></b> 秒钟后页面将自动返回首页
</body>
</html>

<script language="javascript">
	function countDown(secs){
		jump.innerText=secs;
		if(--secs>0)
			setTimeout("countDown("+secs+" )",1000);
	}
	countDown(5);
</script>