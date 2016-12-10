<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>新增图书</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="AddBook" method="post">
		书名:<input name = "bookname" type = "text" style ="width:180px;"><br>
		作者:<input name = "bookauthor" type = "text" style ="width:180px;"><br>
		分类:<select name = "booktype" style ="width:183px;">
			<option value = "小说">小说</option>
			<option value = "文学">文学</option>
			<option value = "历史">历史</option>
			<option value = "政治">政治</option>
		</select><br>
		简介:<input name = "bookinfo" type = "text" style ="width:180px;"><br>
		<input value = "提交" type = "submit" >
	</form>
</body>
</html>