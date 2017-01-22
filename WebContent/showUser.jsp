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
<title>�û���Ϣ</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id = "userInfo">
		<h2><label>�û�����</label>${userNew.userName}</h2>
		<font color="red">${requestScope.error }</font>
		<c:if test="${not empty sessionScope.user }">
			<c:choose>
				<c:when test = "${empty requestScope.follow }">
					<a href="AddFollow?followerUserID=${userNew.userID}&followingUserID=${sessionScope.user.userID }">��ע��</a>
				</c:when>
				<c:otherwise>
					<a href="DeleteFollow?followerUserID=${userNew.userID}&followingUserID=${sessionScope.user.userID }">ȡ����ע</a>
					<form action="AddLetter" method="post">
						<textarea cols="80" rows="10" name="letterContent">����д��˽�Ű�</textarea>
						<script type="text/javascript">CKEDITOR.replace( "letterContent",{
							width:950,height:150,
							toolbar :
				    		[
								['Image','Link']
				    		]});
						</script>
						<input type="hidden" name = "sendUserID" value = "${sessionScope.user.userID }">
						<input type="hidden" name = "receiveUserID" value = "${userNew.userID}">
			 			<input type="submit" value="д˽��">
					</form>
				</c:otherwise>
			</c:choose>
		</c:if>
		<h2><label>���յ�����:</label>${userNew.userApprove}��</h2>
		<h2><label>����������:</label>${userNew.userRead }��</h2>
		<h2><label>�������ĵ�Ӱ:</label>${userNew.userWatch }��</h2>
		<h2><label>�������С��:</label>${userNew.userAttend }��</h2>
	</div>
	
	<c:choose>
	<c:when test="${userNew.userHide==1}">
		<div id = "userInfoadd">
			<h2><label>��ע������:</label>${userNew.userFollower}��</h2>
			<h2><label>����ע����:</label>${userNew.userFollowing}��</h2>
		</div>
		<div id = "test">
			<h2>��û��Ȩ�޲鿴���û���ϸ��Ϣ</h2>
		</div>
	</c:when>
	<c:otherwise>
		<div id = "userInfoadd">
			<h2><label>��ע������:</label><a href="ShowFollow?userID=${userNew.userID }">${userNew.userFollower}��</a></h2>
			<h2><label>����ע����:</label><a href="ShowFollow?userID=${userNew.userID }">${userNew.userFollowing}��</a></h2>
		</div>
		<div class="booklist">
			<h2>�����鵥
			<c:if test="${not empty requestScope.userreadbook }">
				<a href = "ShowAllReadBook?userID=${userNew.userID }">��ʾ����>></a>	
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
			<h2>����Ӱ��
			<c:if test="${not empty requestScope.userwatchfilm }">
				<a href = "ShowAllWatchFilm?userID=${userNew.userID }">��ʾ����>></a>	
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
			<h2>����С�� 
				<c:if test="${not empty requestScope.userattendgroup }">
					<a href = "ShowAllAttendGroup?userID=${userNew.userID }">��ʾ����>></a>	
				</c:if>
			</h2>		
			
			<c:forEach items="${requestScope.userattendgroup }" var="userattendgroup" begin="0" end="3" >
				<li class = "group">
					<div class = "detail">С����:<a href = "ShowGroup?groupID=${userattendgroup.groupID }">${userattendgroup.groupName }</a></div>
					<div class = "detail">����:${userattendgroup.groupType }</div>
					<div class = "detail">������:${userattendgroup.groupPostNum }</div>
					<div class = "detail">��������:${userattendgroup.groupUserNum }</div>
				</li>
			</c:forEach>
		</div>
		<div class="statuslist">
			<h2>���Ķ�̬</h2>
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