<%@page import="factory.UserDaoFactory"%>
<%@page import="bean.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/showletter.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>˽��</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="letter">
	<a href = "ShowAllLetter?receiveUserID=${letter.receiveUserID}">����˽���б�</a>
		<ul>
			<li id="letterinfo">
				<div><a href = "ShowLetter?letterID=${letter.letterID }">${letter.letterContent }</a></div>
				<div class = "detail">������:<a href = "ShowUser?userID=${letter.sendUserID }">${letter.sendUserID }</a></div>
				<div class = "detail">��������:${letter.letterSendTime }</div>
			</li>	
		</ul>
		
		<form action="AddLetter" method="post">
			<textarea cols="80" rows="10" name="letterContent">��Ҫ�ظ�������</textarea>
			<script type="text/javascript">CKEDITOR.replace( "letterContent",{
				width:950,height:200,
				toolbar :
				    [
						['Image','Link']
				    ]});
			</script>
			<input type="hidden" name = "sendUserID" value = "${letter.receiveUserID }">
			<input type="hidden" name = "receiveUserID" value = "${letter.sendUserID }">
 			<input type="submit" value="�ظ�">
		</form>
	</div>
	<%@include file = "footer.jsp"%>
</body>
</html>