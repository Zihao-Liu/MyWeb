<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/personalinfo.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>用户信息</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id = "userInfo">
		<h2><label>用户名：</label>${userNew.userName}</h2>
		<font color="red">${requestScope.error }</font>
		<c:if test="${not empty sessionScope.user }">
			<c:choose>
				<c:when test = "${empty requestScope.follow }">
					<a href="AddFollow?followerUserID=${userNew.userID}&followingUserID=${sessionScope.user.userID }">关注他</a>
				</c:when>
				<c:otherwise>
					<a href="DeleteFollow?followerUserID=${userNew.userID}&followingUserID=${sessionScope.user.userID }">取消关注</a>
					<form action="AddLetter" method="post">
						<textarea cols="80" rows="10" name="letterContent">给他写个私信吧</textarea>
						<script type="text/javascript">CKEDITOR.replace( "letterContent",{
							width:950,height:150,
							toolbar :
				    		[
								['Image','Link']
				    		]});
						</script>
						<input type="hidden" name = "sendUserID" value = "${sessionScope.user.userID }">
						<input type="hidden" name = "receiveUserID" value = "${userNew.userID}">
			 			<input type="submit" value="写私信">
					</form>
				</c:otherwise>
			</c:choose>
		</c:if>
		<h2><label>他收到的赞:</label>${userNew.userApprove}个</h2>
		<h2><label>他读过的书:</label>${userNew.userRead }本</h2>
		<h2><label>他看过的电影:</label>${userNew.userWatch }部</h2>
		<h2><label>他加入的小组:</label>${userNew.userAttend }个</h2>
	</div>
	
	<c:choose>
	<c:when test="${userNew.userHide==1}">
		<div id = "userInfoadd">
			<h2><label>关注他的人:</label>${userNew.userFollower}个</h2>
			<h2><label>他关注的人:</label>${userNew.userFollowing}个</h2>
		</div>
		<div id = "test">
			<h2>您没有权限查看该用户详细信息</h2>
		</div>
	</c:when>
	<c:otherwise>
		<div id = "userInfoadd">
			<h2><label>关注他的人:</label><a href="ShowFollow?userID=${userNew.userID }">${userNew.userFollower}个</a></h2>
			<h2><label>他关注的人:</label><a href="ShowFollow?userID=${userNew.userID }">${userNew.userFollowing}个</a></h2>
		</div>
		<div class="booklist">
			<h2>他的书单
			<c:if test="${not empty requestScope.userreadbook }">
				<a href = "ShowAllReadBook?userID=${userNew.userID }">显示所有>></a>	
			</c:if>
			</h2>		
			
			<c:forEach items="${requestScope.userreadbook}" var="userreadbook" begin="0" end="3">
				<li class = "book">
					<div><img src="${userreadbook.bookCoverPath}"/></div>
					<div><a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
					<div>${userreadbook.bookAuthor}</div>
				</li>
			</c:forEach>
		</div>
		<div class="filmlist">
			<h2>他的影单
			<c:if test="${not empty requestScope.userwatchfilm }">
				<a href = "ShowAllWatchFilm?userID=${userNew.userID }">显示所有>></a>	
			</c:if>	
			</h2>		
					
			<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm" begin="0" end="3" >
				<li class = "film">
					<div><img src="${userwatchfilm.filmCoverPath}"/></div>
					<div><a href = "ShowFilm?filmID=${userwatchfilm.filmID}">${userwatchfilm.filmName }</a></div>
					<div>${userwatchfilm.filmDirector}</div>
				</li>
			</c:forEach>
		</div>
		
		<div class="grouplist">
			<h2>他的小组 
				<c:if test="${not empty requestScope.userattendgroup }">
					<a href = "ShowAllAttendGroup?userID=${userNew.userID }">显示所有>></a>	
				</c:if>
			</h2>		
			
			<c:forEach items="${requestScope.userattendgroup }" var="userattendgroup" begin="0" end="3" >
				<li class = "group">
					<div class = "detail">小组名:<a href = "ShowGroup?groupID=${userattendgroup.groupID }">${userattendgroup.groupName }</a></div>
					<div class = "detail">分类:${userattendgroup.groupType }</div>
					<div class = "detail">帖子数:${userattendgroup.groupPostNum }</div>
					<div class = "detail">加入人数:${userattendgroup.groupUserNum }</div>
				</li>
			</c:forEach>
		</div>
		<div class="statuslist">
			<h2>他的动态</h2>
			<c:forEach items="${requestScope.userstatus}" var="userstatus" begin="0" end="3">
				<li class = "status">
					<div>${userstatus.statusContent }</div>
					<div>${userstatus.publishTime}</div>
				</li>
			</c:forEach>
		</div>
	</c:otherwise>
	</c:choose>
	
	<%@include file = "footer.jsp"%>
</body>
</html>