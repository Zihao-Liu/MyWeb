<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ͼ��</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="AddBook" method="post">
		����:<input name = "bookname" type = "text" style ="width:180px;"><br>
		����:<input name = "bookauthor" type = "text" style ="width:180px;"><br>
		����:<select name = "booktype" style ="width:183px;">
			<option value = "С˵">С˵</option>
			<option value = "��ѧ">��ѧ</option>
			<option value = "��ʷ">��ʷ</option>
			<option value = "����">����</option>
		</select><br>
		���:<input name = "bookinfo" type = "text" style ="width:180px;"><br>
		<input value = "�ύ" type = "submit" >
	</form>
</body>
</html>