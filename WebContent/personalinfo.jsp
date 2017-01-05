<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/personalinfo.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />

<script language="javascript">
function firm(statusID){
	if(confirm("您确定要删除该条动态吗")){
		location.href="DeleteStatus?statusID="+statusID; 
	}
	else{
		alert("取消删除");
	}
}

</script>
<title>我的信息</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id="mid">
		<div id = "userInfo">
			<h2><label>用户名：</label>${userNew.userName}</h2>
			<h2><label>我收到的赞:</label>${userNew.userApprove}个</h2>
			<h2><label>我读过的书:</label>${userNew.userRead }本</h2>
			<h2><label>我看过的电影:</label>${userNew.userWatch }部</h2>
		</div>
		<div class="booklist">
			<h2>我的书单</h2>
			<c:forEach items="${requestScope.userreadbook}" var="userreadbook">
				<li class = "book">
					<div><img src="${userreadbook.bookCoverPath}"/></div>
					<div>书名:<a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
					<div>作者:${userreadbook.bookAuthor}</div>
				</li>
			</c:forEach>
		</div>
		<div class="filmlist">
			<h2>我的影单</h2>
			<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm">
				<li class = "film">
					<div><img src="${userwatchfilm.filmCoverPath}"/></div>
					<div>片名:<a href = "">${userwatchfilm.filmName }</a></div>
					<div>导演:${userwatchfilm.filmDirector}</div>
				</li>
			</c:forEach>
		</div>
		
		<div class="statuslist">
			<h2>我的动态</h2>
			<c:forEach items="${requestScope.userstatus}" var="userstatus">
				<li class = "status">
					<div>${userstatus.statusContent }</div>
					<div>${userstatus.publishTime}</div>
					<%--<a href = "DeleteStatus?statusID=${userstatus.statusID }">删除动态</a> --%>
					<input type="submit" name="Submit2" value="删除动态" onclick="firm(${userstatus.statusID })" />
				</li>
			</c:forEach>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>