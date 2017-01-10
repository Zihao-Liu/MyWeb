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
	if(confirm("��ȷ��Ҫɾ��������̬��")){
		location.href="DeleteStatus?statusID="+statusID; 
	}
	else{
		alert("ȡ��ɾ��");
	}
}

function firm2(bookID,bookScore){
	if(confirm("��ȷ��Ҫɾ����ͼ����")){
		location.href="DeleteBookFromRead?bookID="+bookID+"&bookScore="+bookScore; 
	}
	else{
		alert("ȡ��ɾ��");
	}
}

function firm3(filmID,filmScore){
	if(confirm("��ȷ��Ҫɾ����ӰƬ��")){
		location.href="DeleteFilmFromWatch?filmID="+filmID+"&filmScore="+filmScore; 
	}
	else{
		alert("ȡ��ɾ��");
	}
}
</script>

<title>�ҵ���Ϣ</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id="mid">
		<div id = "userInfo">
			<h2><label>�û�����</label>${userNew.userName}</h2>
			<h2><label>���յ�����:</label>${userNew.userApprove}��</h2>
			<h2><label>�Ҷ�������:</label>${userNew.userRead }��</h2>
			<h2><label>�ҿ����ĵ�Ӱ:</label>${userNew.userWatch }��</h2>
			<h2><label>��ע�ҵ���:</label><a href="showFollower?userID = ${userNew.userID }">${userNew.userFollower}��</a></h2>
			<h2><label>�ҹ�ע����:</label><a href="showFollowing?userID = ${userNew.userID }">${userNew.userFollowing}��</a></h2>
			<h2><a href="ShowAllLetter?receiveUserID=${userNew.userID }">�ҵ�˽���б�</a></h2>
			<form action="ModifyUserHide" method="post" >
				<c:choose>
					<c:when test="${userNew.userHide==0}">
						<label>������Ϣ��ǰΪ�����˿ɼ�</label>
						<label><input name="hide" type="radio" value="0" checked="checked"/>�����˿ɼ�</label>
						<label><input name="hide" type="radio" value="1" />�����˲��ɼ�</label>
					</c:when>
					<c:otherwise>
						<label>������Ϣ��ǰΪ�����˲��ɼ�</label>
						<label><input name="hide" type="radio" value="0" "/>�����˿ɼ�</label>
						<label><input name="hide" type="radio" value="1" checked="checked"/>�����˲��ɼ�</label>
					</c:otherwise>
				</c:choose>
				<input type="submit" value="�ύ"/>
				<input type="hidden" value ="${userNew.userID}" name = "userID"/>
			</form>
		</div>
		<div class="booklist">
			<h2>�ҵ��鵥</h2>
			<c:forEach items="${requestScope.userreadbook}" var="userreadbook">
				<li class = "book">
					<div><img src="${userreadbook.bookCoverPath}"/></div>
					<div><a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
					<div>${userreadbook.bookAuthor}</div>
					<div><input type="submit" name="Submit2" value="ɾ��ͼ��" onclick="firm2(${userreadbook.bookID},${userreadbook.bookScore})" /></div>
				</li>
			</c:forEach>
		</div>
		<div class="filmlist">
			<h2>�ҵ�Ӱ��</h2>
			<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm">
				<li class = "film">
					<div><img src="${userwatchfilm.filmCoverPath}"/></div>
					<div><a href = "">${userwatchfilm.filmName }</a></div>
					<div>${userwatchfilm.filmDirector}</div>
					<div><input type="submit" name="Submit2" value="ɾ����Ӱ" onclick="firm3(${userwatchfilm.filmID},${userwatchfilm.filmScore})" /></div>
				</li>
			</c:forEach>
		</div>
		
		<div class="statuslist">
			<h2>�ҵĶ�̬</h2>
			<c:forEach items="${requestScope.userstatus}" var="userstatus">
				<li class = "status">
					<div>${userstatus.statusContent }</div>
					<div>${userstatus.publishTime}</div>
					<%--<a href = "DeleteStatus?statusID=${userstatus.statusID }">ɾ����̬</a> --%>
					<input type="submit" name="Submit2" value="ɾ����̬" onclick="firm(${userstatus.statusID })" />
				</li>
			</c:forEach>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>