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
	if(confirm("��ȷ��Ҫɾ������������������ɾ�������յ�������")){
		location.href="DeleteBookComment?commentID="+commentID+"&userID="+userID; 
	}
	else{
		alert("ȡ��ɾ��");
	}
}
</script>
<title>С����Ϣ</title>
</head>
<body>
<%@include file = "header.jsp" %> 
<font color="red">${requestScope.error }</font>
	<div class = "groupInfo">
		<h2>${group.groupName}</h2>
		<div class="Infodisplay" >
			<ul>
				<li>����:${group.groupType}</li>
				<li>��������:${group.groupUserNum }</li>
				<li>���Ӹ���:${group.groupPostNum }</li>
			</ul>
		</div>
		<c:if test="${not empty sessionScope.user }">
			<c:choose>
				<c:when test="${empty requestScope.attendflag }">
					<form action="AttendGroup" method="post">
						<input type = "hidden" name = "groupID" value="${group.groupID }">
						<input type = "submit" value="����С��">
					</form>
				</c:when>
				<c:otherwise>
					<form action="OutGroup" method="post">
						<input type = "hidden" name = "groupID" value="${group.groupID }">
						<input type = "submit" value="�˳�С��">
					</form>
				</c:otherwise>
			</c:choose>
		</c:if>
		<h2>���ݼ��:</h2>
		<p class="brief">${group.groupInfo}</p>
	</div>
	
	

	<div class="comment">
		<h2>����</h2>
		<c:forEach items="${requestScope.postList}" var="post">
			<div class="commentInfo">
				<a href="ShowGroupPost?postID=${post.postID }">${post.postTitle }</a>:
				${post.postContent}
				<div class="commentuserInfo">
					������:${post.userID} 
			  		ʱ��:${post.publishTime}
			  		������:${post.postApprove}
			  	</div>
		  	</div>
		</c:forEach>
		
		<div class="commentBox">
			<form action="AddGroupPost" method="post">
				<p>����:<input name = "posttitle" type = "text"></p>
				<p>����:</p>
				
					<textarea cols="80" rows="10" name="postcontent">����ʲô��˵��</textarea>
					<script type="text/javascript">CKEDITOR.replace( "postcontent",{
						width:950,height:300,
						toolbar :'basic'});
					</script>
				<input type="hidden" name="groupID" value="${group.groupID}"/> 
				<p><input value = "�ύ" type = "submit"></p>
			</form>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>