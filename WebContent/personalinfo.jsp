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

function firm2(bookID,bookScore){
	if(confirm("您确定要删除该图书吗")){
		location.href="DeleteBookFromRead?bookID="+bookID+"&bookScore="+bookScore; 
	}
	else{
		alert("取消删除");
	}
}

function firm3(filmID,filmScore){
	if(confirm("您确定要删除该影片吗")){
		location.href="DeleteFilmFromWatch?filmID="+filmID+"&filmScore="+filmScore; 
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
			<h2><label>关注我的人:</label><a href="showFollower?userID = ${userNew.userID }">${userNew.userFollower}个</a></h2>
			<h2><label>我关注的人:</label><a href="showFollowing?userID = ${userNew.userID }">${userNew.userFollowing}个</a></h2>
			<h2><a href="ShowAllLetter?receiveUserID=${userNew.userID }">我的私信列表</a></h2>
			<form action="ModifyUserHide" method="post" >
				<c:choose>
					<c:when test="${userNew.userHide==0}">
						<label>个人信息当前为其他人可见</label>
						<label><input name="hide" type="radio" value="0" checked="checked"/>其他人可见</label>
						<label><input name="hide" type="radio" value="1" />其他人不可见</label>
					</c:when>
					<c:otherwise>
						<label>个人信息当前为其他人不可见</label>
						<label><input name="hide" type="radio" value="0" "/>其他人可见</label>
						<label><input name="hide" type="radio" value="1" checked="checked"/>其他人不可见</label>
					</c:otherwise>
				</c:choose>
				<input type="submit" value="提交"/>
				<input type="hidden" value ="${userNew.userID}" name = "userID"/>
			</form>
		</div>
		<div class="booklist">
			<h2>我的书单</h2>
			<c:forEach items="${requestScope.userreadbook}" var="userreadbook">
				<li class = "book">
					<div><img src="${userreadbook.bookCoverPath}"/></div>
					<div><a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
					<div>${userreadbook.bookAuthor}</div>
					<div><input type="submit" name="Submit2" value="删除图书" onclick="firm2(${userreadbook.bookID},${userreadbook.bookScore})" /></div>
				</li>
			</c:forEach>
		</div>
		<div class="filmlist">
			<h2>我的影单</h2>
			<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm">
				<li class = "film">
					<div><img src="${userwatchfilm.filmCoverPath}"/></div>
					<div><a href = "">${userwatchfilm.filmName }</a></div>
					<div>${userwatchfilm.filmDirector}</div>
					<div><input type="submit" name="Submit2" value="删除电影" onclick="firm3(${userwatchfilm.filmID},${userwatchfilm.filmScore})" /></div>
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