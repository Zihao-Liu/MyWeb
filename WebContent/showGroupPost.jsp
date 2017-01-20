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
function firm1(postID,userID){
	if(confirm("您确定要删除该条帖子吗，这样会删除您所收到的赞数")){
		location.href="DeleteGroupPost?postID="+postID+"&userID="+userID; 
	}
	else{
		alert("取消删除");
	}
}

function firm2(commentID,userID){
	if(confirm("您确定要删除该条评论吗，这样会删除您所收到的赞数")){
		location.href="DeleteGroupPostComment?commentID="+commentID+"&userID="+userID; 
	}
	else{
		alert("取消删除");
	}
}
</script>
<title>帖子信息</title>
</head>
<body>
<%@include file = "header.jsp" %> 
<font color="red">${requestScope.error }</font>
	<div class = "groupInfo">
		<h2>${post.postTitle}</h2>
		<p class="brief">${post.postContent}</p>
		<div class="Infodisplay" >
			<div class="commentuserInfo">
					发帖人:${post.userID} 
			  		时间:${post.publishTime}
			
			  		<c:choose>
			  			<c:when test="${empty sessionScope.user}">
			  			</c:when>
			  			<c:otherwise>
			  				<c:if test="${post.userID == sessionScope.user.userID}"  >
			  					<input type="submit" name="Submit2" value="删除帖子" onclick="firm(${post.postID},${post.userID})" />
			  				</c:if>
			  			</c:otherwise>
			  		</c:choose>
			  		
			  		<a href="ModifyGroupPostApproveNum?postID=${post.postID}&action=1">赞同</a>
			  		${post.postApprove}
			  		<a href="ModifyGroupPostApproveNum?postID=${post.postID}&action=0">反对</a>
			  	</div>
		</div>
		
		
	</div>
	
	

	<div class="comment">
		<h2>评论</h2>
		<c:forEach items="${requestScope.commentList}" var="comment">
			<div class="commentInfo">
				${comment.commentTitle }
				${comment.commentContent}
				<div class="commentuserInfo">
					评论人:${comment.userID} 
			  		时间:${comment.publishTime}
			  		
			  		<c:choose>
			  			<c:when test="${empty sessionScope.user}">
			  			</c:when>
			  			<c:otherwise>
			  				<c:if test="${comment.userID == sessionScope.user.userID}"  >
			  					<input type="submit" name="Submit2" value="删除评论" onclick="firm2(${comment.commentID},${comment.userID})" />
			  				</c:if>
			  			</c:otherwise>
			  		</c:choose>
			  		
			  		<a href="ModifyGroupPostCommentApproveNum?commentID=${comment.commentID}&action=1&postID=${post.postID}">赞同</a>
			  		${comment.commentApprove}
			  		<a href="ModifyGroupPostCommentApproveNum?commentID=${comment.commentID}&action=0&postID=${post.postID}">反对</a>
			  	</div>
		  	</div>
		</c:forEach>
		
		
		<div class="commentBox">
			<form action="AddGroupPostComment" method="post">
				<p>标题:<input name = "commenttitle" type = "text"></p>
				<p>内容:</p>
				
					<textarea cols="80" rows="10" name="commentcontent">你有什么想说的</textarea>
					<script type="text/javascript">CKEDITOR.replace( "commentcontent",{
						width:950,height:300,
						toolbar :'basic'});
					</script>
				<input type="hidden" name="groupID" value="${group.groupID}"/> 
				<input type="hidden" name="postID" value = "${post.postID }">				
				<p><input value = "提交" type = "submit"></p>
			</form>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>