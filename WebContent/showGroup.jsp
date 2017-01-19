<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/showgroup.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script language="javascript">
function firm(postID,userID){
	if(confirm("您确定要删除该条帖子吗，这样会删除您所收到的赞数")){
		location.href="DeleteBookComment?commentID="+commentID+"&userID="+userID; 
	}
	else{
		alert("取消删除");
	}
}
</script>
<title>小组信息</title>
</head>
<body>
<%@include file = "header.jsp" %> 
<font color="red">${requestScope.error }</font>
	<div class = "groupInfo">
		<h2>${group.groupName}</h2>
		<div class="Infodisplay" >
			<ul>
				<li>分类:${group.groupType}</li>
				<li>加入人数:${group.groupUserNum }</li>
				<li>帖子个数:${group.groupPostNum }</li>
			</ul>
		</div>
		<c:if test="${not empty sessionScope.user }">
			<c:choose>
				<c:when test="${empty requestScope.attendflag }">
					<form action="AttendGroup" method="post">
						<input type = "hidden" name = "groupID" value="${group.groupID }">
						<input type = "submit" value="加入小组">
					</form>
				</c:when>
				<c:otherwise>
					<form action="OutGroup" method="post">
						<input type = "hidden" name = "groupID" value="${group.groupID }">
						<input type = "submit" value="退出小组">
					</form>
				</c:otherwise>
			</c:choose>
		</c:if>
		<h2>内容简介:</h2>
		<p class="brief">${group.groupInfo}</p>
	</div>
	
	

	<div class="comment">
		<h2>帖子</h2>
		<c:forEach items="${requestScope.postList}" var="post">
			<div class="commentInfo">
				<a href="ShowGroupPost?postID=${post.postID }">${post.postTitle }</a>:
				${post.postContent}
				<div class="commentuserInfo">
					发帖人:${post.userID} 
			  		时间:${post.publishTime}
			  		点赞数:${post.postApprove}
			  	</div>
		  	</div>
		</c:forEach>
		
		<div class="commentBox">
			<form action="AddGroupPost" method="post">
				<p>标题:<input name = "posttitle" type = "text"></p>
				<p>内容:</p>
				
					<textarea cols="80" rows="10" name="postcontent">你有什么想说的</textarea>
					<script type="text/javascript">CKEDITOR.replace( "postcontent",{
						width:950,height:300,
						toolbar :'basic'});
					</script>
				<input type="hidden" name="groupID" value="${group.groupID}"/> 
				<p><input value = "提交" type = "submit"></p>
			</form>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>