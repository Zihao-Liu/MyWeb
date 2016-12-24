<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<link href="personalinfo.css" type="text/css" rel="stylesheet" media="all" />
<title>������Ϣ</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id = "userInfo">
		<h2><label>�û�����</label>${user.userName}</h2>
		<h2><label>���յ�����:</label>${user.userApprove}</h2>
		<h2><label>�Ҷ�������:</label>${user.userRead }</h2>
	</div>
	<div class="booklist">
	<c:forEach items="${requestScope.userreadbook}" var="userreadbook">
		<li class = "book">
			<div><img src="${userreadbook.bookCoverPath}"/></div>
			<div>����:<a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
			<div>����:${userreadbook.bookAurthor}</div>
		</li>
	</c:forEach>
	</div>
</body>
</html>